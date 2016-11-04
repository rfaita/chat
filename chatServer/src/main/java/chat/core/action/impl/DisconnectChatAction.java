package chat.core.action.impl;

import chat.Chat;
import chat.core.action.Action;
import chat.core.connection.Connection;
import chat.core.message.impl.DisconnectChatMessage;
import chat.core.message.impl.RefreshChatMessage;
import chat.core.message.impl.TalkMessage;
import chat.core.thread.ThreadBackMessage;
import chat.entity.ChatRoom;
import chat.entity.Usuario;

/**
 *
 * @author rafael
 */
public class DisconnectChatAction extends Action<DisconnectChatMessage> {

    public DisconnectChatAction(Connection c, DisconnectChatMessage m) {
        super(c, m);
    }

    @Override
    public void execute() throws Exception {

        ChatRoom cr = Chat.getInstance().getChatRoom(m.getChat());

        Usuario u = Chat.getInstance().getUsuario(m.getUsuario());

        if (u != null) {
            m.setUsuario(u);
            if (cr != null && cr.isOpen()) {
                if (cr.getUsuarios().contains(u)) {
                    
                    m.setChat(ChatRoom.newCleanChatRoom(cr));

                    for (Usuario u2 : Chat.getInstance().getChatRoom(cr).getUsuarios()) {
                        new ThreadBackMessage(u2.getCon(), m).start();
                    }

                    cr.getUsuarios().remove(u);

                    new RefreshChatAction(c, new RefreshChatMessage(m.getUsuario(), ChatRoom.newCleanChatRoom(cr))).execute();

                } else {
                    new ThreadBackMessage(u.getCon(), new TalkMessage(u, ChatRoom.newCleanChatRoom(cr), "VOCÊ NÃO ESTA NA SALA " + m.getChat().getNome() + " PARA SE DESCONECTAR")).start();
                }
            } else {
                new ThreadBackMessage(u.getCon(), new TalkMessage(u, null, "A SALA " + m.getChat().getNome() + " ESTA FECHADA")).start();
            }
        }


    }
}
