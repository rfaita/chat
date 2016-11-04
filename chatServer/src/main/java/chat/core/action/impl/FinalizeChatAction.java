package chat.core.action.impl;

import chat.Chat;
import chat.core.action.Action;
import chat.core.connection.Connection;
import chat.core.message.impl.FinalizeChatMessage;
import chat.core.message.impl.TalkMessage;
import chat.core.thread.ThreadBackMessage;
import chat.entity.ChatRoom;
import chat.entity.Usuario;

/**
 *
 * @author rafael
 */
public class FinalizeChatAction extends Action<FinalizeChatMessage> {

    public FinalizeChatAction(Connection c, FinalizeChatMessage m) {
        super(c, m);
    }

    @Override
    public void execute() throws Exception {


        ChatRoom cr = Chat.getInstance().getChatRoom(m.getChat());

        Usuario u = Chat.getInstance().getUsuario(m.getUsuario());

        if (u != null) {
            m.setUsuario(u);
            if (cr != null && cr.isOpen()) {

                if (cr.isClosable()) {

                    m.setChat(ChatRoom.newCleanChatRoom(cr));
                    
                    for (Usuario u2 : Chat.getInstance().getUsuarios()) {
                        new ThreadBackMessage(u2.getCon(), m).start();
                    }

                    Chat.getInstance().destroyChatRoom(cr);
                    cr = null;
                } else {
                    new ThreadBackMessage(u.getCon(), new TalkMessage(u, null, "A SALA " + m.getChat().getNome() + " NAO PODE SER FECHADA")).start();
                }

            } else {
                new ThreadBackMessage(u.getCon(), new TalkMessage(u, null, "A SALA " + m.getChat().getNome() + " ESTA FECHADA")).start();
            }
        }


    }
}
