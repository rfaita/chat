package chat.chatclient.core.action.impl;

import chat.chatclient.ChatClient;
import chat.chatclient.GUI;
import chat.chatclient.core.action.Action;
import chat.core.message.impl.RefreshChatMessage;

/**
 *
 * @author rafael
 */
public class RefreshChatAction extends Action<RefreshChatMessage> {

    public RefreshChatAction(ChatClient cc, RefreshChatMessage m) {
        super(cc, m);
    }

    @Override
    public void execute() throws Exception {


        GUI cg = this.cc.getGUI();

        cg.refreshChat(m.getChat());

    }
}
