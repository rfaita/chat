package chat.chatclient.core.action.impl;

import chat.chatclient.ChatClient;
import chat.chatclient.GUI;
import chat.chatclient.core.action.Action;
import chat.core.message.impl.InitiatedChatMessage;
import chat.entity.ChatRoom;

/**
 *
 * @author rafael
 */
public class InitiatedChatAction extends Action<InitiatedChatMessage> {

    public InitiatedChatAction(ChatClient cc, InitiatedChatMessage m) {
        super(cc, m);
    }

    @Override
    public void execute() throws Exception {

        GUI cg = this.cc.getGUI();

        for (ChatRoom cr : m.getChats()) {
            cg.addChat(cr);
        }

    }
}
