package chat.chatclient.core.action.impl;

import chat.chatclient.ChatClient;
import chat.chatclient.GUI;
import chat.chatclient.core.action.Action;
import chat.core.message.impl.ConnectionMessage;

/**
 * i
 *
 *
 * @author rafael
 */
public class ConnectionAction extends Action<ConnectionMessage> {

    public ConnectionAction(ChatClient cc, ConnectionMessage m) {
        super(cc, m);
    }

    @Override
    public void execute() throws Exception {

        GUI cg = this.cc.getGUI();

        cg.addConnectionMessage(m);

    }
}
