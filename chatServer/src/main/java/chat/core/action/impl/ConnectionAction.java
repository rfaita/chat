package chat.core.action.impl;

import java.util.Random;
import chat.Chat;
import chat.core.action.Action;
import chat.core.connection.Connection;
import chat.core.message.impl.ConnectionMessage;
import chat.core.thread.ThreadBackMessage;
import chat.entity.Usuario;

/**
 *
 * @author rafael
 */
public class ConnectionAction extends Action<ConnectionMessage> {

    public ConnectionAction(Connection c, ConnectionMessage m) {
        super(c, m);
    }

    @Override
    public synchronized void execute() throws Exception {

        //Procurar por id usuário

        Usuario u = new Usuario();
        u.setId(new Random().nextInt());
        u.setNome(m.getUsuario().getNome());
        u.setCon(c);

        Chat.getInstance().getUsuarios().add(u);

        m.setUsuario(u);

        for (Usuario u2 : Chat.getInstance().getUsuarios()) {
            new ThreadBackMessage(u2.getCon(), m).start();
        }

    }
}
