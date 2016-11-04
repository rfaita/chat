package chat.core.action.impl;

import java.util.ArrayList;
import chat.Chat;
import chat.core.action.Action;
import chat.core.connection.Connection;
import chat.core.message.impl.InitiatedChatMessage;
import chat.core.thread.ThreadBackMessage;
import chat.entity.ChatRoom;
import chat.entity.Usuario;

/**
 *
 * @author rafael
 */
public class InitiatedChatAction extends Action<InitiatedChatMessage> {

    public InitiatedChatAction(Connection c, InitiatedChatMessage m) {
        super(c, m);
    }

    @Override
    public void execute() throws Exception {

        Usuario u = Chat.getInstance().getUsuario(m.getUsuario());

        m.setUsuario(u);
        m.setChats(new ArrayList<ChatRoom>());
        for (ChatRoom cr : Chat.getInstance().getChatsRooms()) {
            m.getChats().add(ChatRoom.newCleanChatRoom(cr));
        }

        new ThreadBackMessage(u.getCon(), m).start();

    }
}
