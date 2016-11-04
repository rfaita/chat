package chat.core.action.impl;

import chat.Chat;
import chat.core.action.Action;
import chat.core.connection.Connection;
import chat.core.message.impl.InitiateChatMessage;
import chat.core.message.impl.TalkMessage;
import chat.core.thread.ThreadBackMessage;
import chat.entity.ChatRoom;
import chat.entity.Usuario;

/**
 *
 * @author rafael
 */
public class InitiateChatAction extends Action<InitiateChatMessage> {

    public InitiateChatAction(Connection c, InitiateChatMessage m) {
        super(c, m);
    }

    @Override
    public void execute() throws Exception {


        ChatRoom cr = Chat.getInstance().createChatRoom(m.getChat().getIdSAC());

        Chat.getInstance().getChatsRooms().add(cr);

        Usuario u = Chat.getInstance().getUsuario(m.getUsuario());

        if (u != null) {
            if (cr != null && cr.isOpen()) {
                cr.getUsuarios().add(u);
                m.setChat(ChatRoom.newCleanChatRoom(cr));
                new ThreadBackMessage(u.getCon(), m).start();
                for (Usuario u2 : Chat.getInstance().getUsuarios()) {
                    if (!u2.equals(u)) {
                        new ThreadBackMessage(u2.getCon(), m).start();
                    }
                }
            } else {
                new ThreadBackMessage(u.getCon(), new TalkMessage(u, null, "IMPOSSÍVEL CRIAR UMA SALA")).start();
            }
        }


    }
}
