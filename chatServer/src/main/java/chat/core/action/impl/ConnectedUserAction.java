package chat.core.action.impl;

import chat.Chat;
import chat.core.action.Action;
import chat.core.connection.Connection;
import chat.core.message.impl.ConnectedUserMessage;
import chat.core.thread.ThreadBackMessage;
import chat.entity.Usuario;

/**
 *
 * @author rafael
 */
public class ConnectedUserAction extends Action<ConnectedUserMessage> {

    public ConnectedUserAction(Connection c, ConnectedUserMessage m) {
        super(c, m);
    }

    @Override
    public void execute() throws Exception {

        Usuario u = Chat.getInstance().getUsuario(m.getUsuario());

        m.setUsuario(u);
        m.setUsuarios(Chat.getInstance().getUsuarios());

        new ThreadBackMessage(u.getCon(), m).start();

    }
}
