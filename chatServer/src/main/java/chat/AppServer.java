package chat;

import chat.core.connection.Connection;
import chat.core.connection.impl.ConnectionImpl;
import chat.core.thread.ThreadClearOffUsuario;
import chat.core.thread.ThreadMarkOnOffUsuario;
import chat.core.thread.ThreadOnMessage;
import chat.core.thread.ThreadPingSocket;
import chat.entity.ChatRoom;
import chat.entity.Usuario;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AppServer {

    private static final Logger logger = Logger.getLogger(AppServer.class.getName());
    private ServerSocket serverSocket;
    private ServerSocket policyServerSocket;
    private ThreadPingSocket ping;
    private ThreadMarkOnOffUsuario mark;
    private ThreadClearOffUsuario clear;
    public static boolean running = false;

    public void start() throws Exception {

        logger.log(Level.INFO, "INICIALIZANDO SERVIDOR");

        running = true;

        serverSocket = new ServerSocket(12345);
        policyServerSocket = new ServerSocket(12346);

        Chat.getInstance().setStatus(ChatStatus.NORMAL);

        ping = new ThreadPingSocket();
        mark = new ThreadMarkOnOffUsuario();
        clear = new ThreadClearOffUsuario();

        ping.start();
        mark.start();
        clear.start();


        Thread main = new Thread(new Runnable() {

            @Override
            public void run() {
                while (running && !serverSocket.isClosed()) {
                    try {
                        Connection c = ConnectionImpl.getConnection(serverSocket.accept());

                        logger.log(Level.INFO, "NOVA CONEXAO -> ip: {0}", c.getIP());

                        ThreadOnMessage.newThreadOnMessage(c.getIP() + ":" + c.getPort(), c).start();
                        Thread.yield();
                    } catch (Exception ex) {
                        logger.log(Level.SEVERE, ex.getMessage(), ex);
                    }

                }
            }
        });
        main.setName(AppServer.class.getName());
        main.start();
        Thread policy = new Thread(new Runnable() {

            @Override
            public void run() {
                while (running && !policyServerSocket.isClosed()) {
                    try {

                        Socket s = policyServerSocket.accept();

                        byte b[] = new byte[22];
                        s.getInputStream().read(b, 0, 22);
                        if (new String(b).equals("<policy-file-request/>")) {
                            s.getOutputStream().write(("<?xml version=\"1.0\"?>"
                                    + "<cross-domain-policy>"
                                    + "<allow-access-from domain=\"*\" to-ports=\"12345\" secure=\"false\"/>"
                                    + "<site-control permitted-cross-domain-policies=\"all\"/>"
                                    + "</cross-domain-policy>" + '\0').getBytes());
                        }

                        s.close();

                        Thread.yield();

                    } catch (Exception ex) {
                        logger.log(Level.SEVERE, ex.getMessage(), ex);
                    }

                }
            }
        });
        policy.setName("logic.intralogic.chat.PolicyAppServer");
        policy.start();


    }

    public void stop() {
        try {
            serverSocket.close();
            running = false;
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

    public static void main(String[] args) throws Exception {
        AppServer ap = new AppServer();
        ap.start();

        Scanner sc = new Scanner(System.in);

        System.out.print("server:");
        while (sc.hasNext()) {
            System.out.print("server:");
            String cmd = sc.next();
            if (cmd.equals("start")) {
                if (!running) {
                    ap.start();
                    running = true;
                }
            } else if (cmd.equals("stop")) {
                if (running) {
                    ap.stop();
                    running = false;
                }
            } else if (cmd.equals("restart")) {
                if (running) {
                    ap.stop();
                    running = false;
                    ap.start();
                }
            } else if (cmd.equals("exit")) {
                if (running) {
                    ap.stop();
                    running = false;
                }
                break;
            } else if (cmd.equals("status")) {
                System.out.println("STATUS " + Chat.getInstance().getStatus());
                System.out.println("SALAS");
                for (ChatRoom cr : Chat.getInstance().getChatsRooms()) {
                    System.out.println(cr);
                }
                System.out.println("USUARIOS");
                for (Usuario u : Chat.getInstance().getUsuarios()) {
                    System.out.println(u);
                }

            }
        }


    }
}
