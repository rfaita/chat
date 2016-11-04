package chat.core.action.impl;

import chat.Chat;
import chat.core.action.Action;
import chat.core.connection.Connection;
import chat.core.message.impl.InviteChatMessage;
import chat.core.message.impl.TalkMessage;
import chat.core.thread.ThreadBackMessage;
import chat.entity.ChatRoom;
import chat.entity.Usuario;

/**
 *
 * @author rafael
 */
public class InviteChatAction extends Action<InviteChatMessage> {

    public InviteChatAction(Connection c, InviteChatMessage m) {
        super(c, m);
    }

    @Override
    public void execute() throws Exception {


        ChatRoom cr = Chat.getInstance().getChatRoom(m.getChat());

        Usuario u = Chat.getInstance().getUsuario(m.getUsuario());

        if (u != null) {
            m.setUsuario(u);
            if (cr != null && cr.isOpen()) {

                m.setChat(cr);

                Usuario uD = Chat.getInstance().getUsuario(m.getUsuarioDestino());

                if (uD != null) {
                    m.setUsuarioDestino(uD);

                    new ThreadBackMessage(uD.getCon(), m).start();
                } else {
                    new ThreadBackMessage(u.getCon(), new TalkMessage(u, null, "USUÁRIO NÃO LOCALIZADO")).start();
                }

            } else {
                new ThreadBackMessage(u.getCon(), new TalkMessage(u, null, "A SALA " + m.getChat().getNome() + " ESTA FECHADA")).start();
            }
        }


    }
}
