package chat.core.thread;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import chat.Chat;
import chat.ChatStatus;
import chat.core.connection.Connection;
import chat.core.message.Message;

public class ThreadBackMessage extends Thread {

    private Connection c;
    private Message m;
    private static final Logger logger = Logger.getLogger(ThreadBackMessage.class.getName());

    public ThreadBackMessage(Connection c, Message m) {

        this.c = c;
        this.m = m;
    }

    @Override
    public void run() {
        try {
            String s = m.asJSON();
            logger.log(Level.INFO, "MSG SERVER -> CLIENT: {0}", s);
            this.c.getOutputStream().writeUTF(s);
            this.c.getOutputStream().flush();
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Problemas ao enviar messangem ao client.", ex);
            try {
                if (!c.isClosed()) {
                    synchronized (Chat.getInstance()) {
                        Chat.getInstance().setStatus(ChatStatus.MARCAR);
                        Chat.getInstance().notifyAll();
                    }
                    c.disconnect();
                }
            } catch (IOException e) {
                logger.log(Level.SEVERE, "Problemas ao desconectar.", e);
            }
        }

    }
}
