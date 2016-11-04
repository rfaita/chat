package chat.core.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import chat.AppServer;
import chat.Chat;
import chat.ChatStatus;
import chat.entity.ChatRoom;
import chat.entity.Usuario;

/**
 *
 * @author rafael
 */
public class ThreadMarkOnOffUsuario extends Thread {

    private static final Logger logger = Logger.getLogger(ThreadMarkOnOffUsuario.class.getName());

    public ThreadMarkOnOffUsuario() {
        super(ThreadMarkOnOffUsuario.class.getName());
    }
    
    @Override
    public void run() {

        while (AppServer.running) {

            try {

                synchronized (Chat.getInstance()) {
                    while (!Chat.getInstance().getStatus().equals(ChatStatus.MARCAR)) {
                        Chat.getInstance().wait();
                    }
                }
                
                logger.log(Level.INFO, "MARCANDO USUARIO: CHAT STATUS -> {0}", Chat.getInstance().getStatus());
                List<Usuario> tempOnline;
                List<Usuario> tempOffline;


                for (ChatRoom cr : Chat.getInstance().getChatsRooms()) {
                    tempOnline = new ArrayList<Usuario>();
                    tempOffline = new ArrayList<Usuario>();
                    for (Usuario u : cr.getUsuarios()) {
                        if (!u.getCon().isClosed()) {
                            tempOnline.add(u);
                        } else {
                            tempOffline.add(u);
                        }
                    }
                    cr.setUsuarios(tempOnline);
                    cr.setUsuariosOffline(tempOffline);
                }

                tempOnline = new ArrayList<Usuario>();
                tempOffline = new ArrayList<Usuario>();

                for (Usuario u : Chat.getInstance().getUsuarios()) {
                    if (!u.getCon().isClosed()) {
                        tempOnline.add(u);
                    } else {
                        logger.log(Level.INFO, "MARCANDO USUARIO -> usuario OFF:{0}", u);
                        tempOffline.add(u);
                    }
                }

                Chat.getInstance().setUsuarios(tempOnline);
                Chat.getInstance().setUsuariosOffline(tempOffline);

                synchronized (Chat.getInstance()) {
                    if (!Chat.getInstance().getUsuariosOffline().isEmpty()) {
                        Chat.getInstance().setStatus(ChatStatus.MARCADO);
                        Chat.getInstance().notifyAll();
                    }
                }


            } catch (Exception ex) {
                logger.log(Level.SEVERE, "Problemas ao marcar usuários on/off.", ex);
            }
        }
    }
}
