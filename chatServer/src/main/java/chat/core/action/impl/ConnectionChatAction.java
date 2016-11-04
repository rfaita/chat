package chat.core.action.impl;

import chat.Chat;
import chat.core.action.Action;
import chat.core.connection.Connection;
import chat.core.message.impl.ConnectionChatMessage;
import chat.core.message.impl.RefreshChatMessage;
import chat.core.message.impl.TalkMessage;
import chat.core.thread.ThreadBackMessage;
import chat.entity.ChatRoom;
import chat.entity.Usuario;

/**
 *
 * @author rafael
 */
public class ConnectionChatAction extends Action<ConnectionChatMessage> {

    public ConnectionChatAction(Connection c, ConnectionChatMessage m) {
        super(c, m);
    }

    @Override
    public void execute() throws Exception {

        ChatRoom cr = Chat.getInstance().getChatRoom(m.getChat());

        Usuario u = Chat.getInstance().getUsuario(m.getUsuario());

        if (u != null) {
            if (cr != null && cr.isOpen()) {
                if (!cr.getUsuarios().contains(u)) {

                    cr.getUsuarios().add(u);
                    m.setChat(cr);
                    m.setUsuario(u);

                    for (Usuario u2 : Chat.getInstance().getChatRoom(cr).getUsuarios()) {
                        new ThreadBackMessage(u2.getCon(), m).start();
                    }
                    
                    new RefreshChatAction(c, new RefreshChatMessage(m.getUsuario(), ChatRoom.newCleanChatRoom(cr))).execute();
                } else {
                    new ThreadBackMessage(u.getCon(), new TalkMessage(u, ChatRoom.newCleanChatRoom(cr), "VOCÊ JÁ ESTA NA SALA " + cr.getNome())).start();
                }
            } else {
                new ThreadBackMessage(u.getCon(), new TalkMessage(u, null, "A SALA ESTA FECHADA")).start();
            }
        }


    }
}
