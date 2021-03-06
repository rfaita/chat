package chat.chatclient.core.action.impl;

import chat.chatclient.ChatClient;
import chat.chatclient.GUI;
import chat.chatclient.core.action.Action;
import chat.core.message.impl.DisconnectChatMessage;

/**
 *
 * @author rafael
 */
public class DisconnectChatAction extends Action<DisconnectChatMessage> {

    public DisconnectChatAction(ChatClient cc, DisconnectChatMessage m) {
        super(cc, m);
    }

    @Override
    public void execute() throws Exception {

        GUI cg = this.cc.getGUI();

        cg.addDisconnectChatMessage(m);

    }
}
