package chat.core.thread;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import chat.core.connection.Connection;

public class ThreadOnMessage extends Thread {

    private Connection c;
    private static final Logger logger = Logger.getLogger(ThreadOnMessage.class.getName());

    public ThreadOnMessage(String n, Connection c) throws IOException {
        super(n);
        this.c = c;

    }

    @Override
    public void run() {
        try {
            while (!this.isInterrupted() && !c.isClosed()) {

                ThreadAction.newAction(c, c.getInputStream().readUTF()).start();

                ThreadOnMessage.yield();
            }
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Problemas ao receber messangem do servidor.", ex);
        }
    }

    public static ThreadOnMessage newThreadOnMessage(String n, Connection c) throws Exception {
        return new ThreadOnMessage(n, c);
    }
}
