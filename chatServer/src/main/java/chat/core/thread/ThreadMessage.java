package chat.core.thread;

import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import chat.core.connection.Connection;
import chat.core.message.Message;

public class ThreadMessage extends Thread {

    private Connection c;
    private Queue<Message> m = new ArrayBlockingQueue<Message>(100);
    private static final Logger logger = Logger.getLogger(ThreadMessage.class.getName());

    public ThreadMessage(Connection c) {
        this.c = c;
    }

    public synchronized void send(Message m) {
        this.m.add(m);
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted() && !this.c.isClosed()) {
                if (this.m != null && this.m.size() > 0) {
                    this.c.getOutputStream().writeUTF(m.poll().asJSON());
                    this.c.getOutputStream().flush();
                }
                ThreadMessage.yield();
            }
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Problemas ao enviar messangem ao servidor.", ex);
        } finally {
            try {
                if (!c.isClosed()) {
                    c.disconnect();
                }
            } catch (IOException ex) {
                logger.log(Level.SEVERE, "Problemas ao desconectar.", ex);
            }
        }
    }
}
