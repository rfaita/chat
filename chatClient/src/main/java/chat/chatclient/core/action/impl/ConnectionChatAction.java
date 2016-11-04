package chat.chatclient.core.action.impl;

import chat.chatclient.ChatClient;
import chat.chatclient.GUI;
import chat.chatclient.core.action.Action;
import chat.core.message.impl.ConnectionChatMessage;

/**
 *
 * @author rafael
 */
public class ConnectionChatAction extends Action<ConnectionChatMessage> {

    public ConnectionChatAction(ChatClient cc, ConnectionChatMessage m) {
        super(cc, m);
    }

    @Override
    public void execute() throws Exception {


        GUI cg = this.cc.getGUI();

        cg.addConnectionChatMessage(m);

    }
}
