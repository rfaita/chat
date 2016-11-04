package chat.core.action.impl;

import chat.Chat;
import chat.core.action.Action;
import chat.core.connection.Connection;
import chat.core.message.impl.PingMessage;
import chat.core.thread.ThreadBackMessage;
import chat.entity.Usuario;

/**
 *
 * @author rafael
 */
public class PingAction extends Action<PingMessage> {

    public PingAction(Connection c, PingMessage m) {
        super(c, m);
    }

    @Override
    public void execute() throws Exception {

        Usuario u = Chat.getInstance().getUsuario(m.getUsuario());

        m.setUsuario(u);

        new ThreadBackMessage(u.getCon(), m).start();

    }
}
