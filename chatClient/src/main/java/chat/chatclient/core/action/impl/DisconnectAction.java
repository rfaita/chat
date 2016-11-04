package chat.chatclient.core.action.impl;

import chat.chatclient.ChatClient;
import chat.chatclient.GUI;
import chat.chatclient.core.action.Action;
import chat.core.message.impl.DisconnectMessage;

/**
 *
 * @author rafael
 */
public class DisconnectAction extends Action<DisconnectMessage> {

    public DisconnectAction(ChatClient cc, DisconnectMessage m) {
        super(cc, m);
    }

    @Override
    public void execute() throws Exception {

        GUI cg = this.cc.getGUI();

        cg.addDisconnectMessage(m);

    }
}
