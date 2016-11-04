package chat.core.action.impl;

import chat.Chat;
import chat.core.action.Action;
import chat.core.connection.Connection;
import chat.core.message.impl.DisconnectMessage;
import chat.core.thread.ThreadBackMessage;
import chat.entity.Usuario;

/**
 *
 * @author rafael
 */
public class DisconnectAction extends Action<DisconnectMessage> {

    public DisconnectAction(Connection c, DisconnectMessage m) {
        super(c, m);
    }

    @Override
    public void execute() throws Exception {

        Usuario u = Chat.getInstance().getUsuario(m.getUsuario());

        m.setUsuario(u);
        for (Usuario u2 : Chat.getInstance().getUsuarios()) {
            new ThreadBackMessage(u2.getCon(), m).start();
        }

        Chat.getInstance().getUsuarios().remove(u);

    }
}
