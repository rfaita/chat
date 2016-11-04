package chat.core.thread;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import chat.AppServer;
import chat.Chat;
import chat.ChatStatus;
import chat.core.message.impl.DisconnectChatMessage;
import chat.core.message.impl.DisconnectMessage;
import chat.entity.ChatRoom;
import chat.entity.Usuario;

/**
 *
 * @author rafael
 */
public class ThreadClearOffUsuario extends Thread {

    private static final Logger logger = Logger.getLogger(ThreadClearOffUsuario.class.getName());

    public ThreadClearOffUsuario() {
        super(ThreadClearOffUsuario.class.getName());
    }
    
    @Override
    public void run() {
        while (AppServer.running) {
            try {

                synchronized (Chat.getInstance()) {
                    while (!Chat.getInstance().getStatus().equals(ChatStatus.MARCADO)) {
                        Chat.getInstance().wait();
                    }
                }

                logger.log(Level.INFO, "LIMPANDO USUARIO: CHAT STATUS -> {0}", Chat.getInstance().getStatus());

                for (ChatRoom cr : Chat.getInstance().getChatsRooms()) {
                    for (Usuario uOff : cr.getUsuariosOffline()) {
                        for (Usuario uO : cr.getUsuarios()) {
                            new ThreadBackMessage(uO.getCon(), new DisconnectChatMessage(uOff, cr)).start();
                        }
                    }
                }

                for (ChatRoom cr : Chat.getInstance().getChatsRooms()) {
                    cr.setUsuariosOffline(new ArrayList<Usuario>());
                }


                for (Usuario uOff : Chat.getInstance().getUsuariosOffline()) {
                    logger.log(Level.INFO, "LIMPANDO USUARIO -> usuario: {0}", uOff);
                    for (Usuario uO : Chat.getInstance().getUsuarios()) {
                        new ThreadBackMessage(uO.getCon(), new DisconnectMessage(uOff)).start();
                    }
                }

                Chat.getInstance().setUsuariosOffline(new ArrayList<Usuario>());

                synchronized (Chat.getInstance()) {
                    if (Chat.getInstance().getUsuariosOffline().isEmpty()) {
                        Chat.getInstance().setStatus(ChatStatus.NORMAL);
                        Chat.getInstance().notifyAll();
                    }
                }

            } catch (Exception ex) {
                logger.log(Level.SEVERE, "Problemas ao limpar usuários off.", ex);
            }

        }

    }
}
