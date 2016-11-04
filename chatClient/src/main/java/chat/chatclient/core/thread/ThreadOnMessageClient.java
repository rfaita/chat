package chat.chatclient.core.thread;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import chat.chatclient.ChatClient;

public class ThreadOnMessageClient extends Thread {

    private ChatClient cc;
    private static final Logger logger = Logger.getLogger(ThreadOnMessageClient.class.getName());

    public ThreadOnMessageClient(ChatClient cc) throws IOException {
        this.cc = cc;
    }

    @Override
    public void run() {
        try {
            while (!this.isInterrupted() && !cc.getConnection().isClosed()) {
                ThreadActionClient.newActionClient(cc, cc.getConnection().getInputStream().readUTF()).start();
                ThreadOnMessageClient.yield();
            }
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Problemas ao receber messangem do servidor.", ex);
        } finally {
            try {
                if (!cc.getConnection().isClosed()) {
                    cc.getConnection().disconnect();
                }
            } catch (IOException ex) {
                logger.log(Level.SEVERE, "Problemas ao desconectar.", ex);
            }
        }
    }

}
