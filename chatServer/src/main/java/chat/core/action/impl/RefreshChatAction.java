package chat.core.action.impl;

import java.util.ArrayList;
import java.util.List;
import chat.Chat;
import chat.core.action.Action;
import chat.core.connection.Connection;
import chat.core.message.impl.RefreshChatMessage;
import chat.core.message.impl.TalkMessage;
import chat.core.thread.ThreadBackMessage;
import chat.entity.ChatRoom;
import chat.entity.Usuario;

/**
 *
 * @author rafael
 */
public class RefreshChatAction extends Action<RefreshChatMessage> {

    public RefreshChatAction(Connection c, RefreshChatMessage m) {
        super(c, m);
    }

    @Override
    public void execute() throws Exception {

        ChatRoom cr = Chat.getInstance().getChatRoom(m.getChat());

        Usuario u = Chat.getInstance().getUsuario(m.getUsuario());

        if (u != null) {
            if (cr != null && cr.isOpen()) {
                m.setChat(cr);
                m.setUsuario(u);

                List<Usuario> usuariosNaoLogadosChat = new ArrayList<Usuario>(Chat.getInstance().getUsuarios());
                usuariosNaoLogadosChat.removeAll(Chat.getInstance().getChatRoom(cr).getUsuarios());

                for (Usuario u2 : usuariosNaoLogadosChat) {
                    new ThreadBackMessage(u2.getCon(), m).start();
                }
            } else {
                new ThreadBackMessage(u.getCon(), new TalkMessage(u, null, "A SALA ESTA FECHADA")).start();
            }
        }


    }
}
