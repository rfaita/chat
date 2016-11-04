package chat.core.thread;

import java.util.logging.Level;
import java.util.logging.Logger;
import chat.AppServer;
import chat.Chat;
import chat.ChatStatus;
import chat.core.message.impl.PingMessage;
import chat.entity.Usuario;

/**
 *
 * @author rafael
 */
public class ThreadPingSocket extends Thread {

    private static final Logger logger = Logger.getLogger(ThreadPingSocket.class.getName());

    public ThreadPingSocket() {
        super(ThreadPingSocket.class.getName());
    }

    @Override
    public void run() {
        while (AppServer.running) {
            try {

                synchronized (Chat.getInstance()) {
                    while (!Chat.getInstance().getStatus().equals(ChatStatus.NORMAL)) {
                        Chat.getInstance().wait();
                    }
                }

                Thread.sleep(10000);

                logger.log(Level.INFO, "PINGANDO USUARIO: CHAT STATUS -> {0}", Chat.getInstance().getStatus());

                for (Usuario u : Chat.getInstance().getUsuarios()) {
                    if (!u.getCon().isClosed()) {
                        new ThreadBackMessage(u.getCon(), new PingMessage(u)).start();
                    }
                }

            } catch (Exception ex) {
                logger.log(Level.SEVERE, "Problemas ao pingar sockets.", ex);
            }

        }

    }
}
