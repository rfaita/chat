package chat.chatclient.core.action.impl;

import chat.chatclient.ChatClient;
import chat.chatclient.GUI;
import chat.chatclient.core.action.Action;
import chat.core.message.impl.ConnectedUserMessage;
import chat.entity.Usuario;

/**
 * i
 *
 *
 * @author rafael
 */
public class ConnectedUserAction extends Action<ConnectedUserMessage> {

    public ConnectedUserAction(ChatClient cc, ConnectedUserMessage m) {
        super(cc, m);
    }

    @Override
    public void execute() throws Exception {

        Usuario u = this.cc.getUsuario();

        GUI cg = this.cc.getGUI();

        int index = cg.getSelectedUser();

        for (Usuario u2 : m.getUsuarios()) {
            if (!u2.equals(u)) {
                cg.addUser(u2);
            }

            cg.selectUser(index);


        }
    }
}
