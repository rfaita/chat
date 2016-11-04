package chat.chatclient.core.action.impl;

import chat.chatclient.ChatClient;
import chat.chatclient.GUI;
import chat.chatclient.core.action.Action;
import chat.core.message.impl.FinalizeChatMessage;


/**
 *
 * @author rafael
 */
public class FinalizeChatAction extends Action<FinalizeChatMessage> {

    public FinalizeChatAction(ChatClient cc, FinalizeChatMessage m) {
        super(cc, m);
    }

    @Override
    public void execute() throws Exception {


        GUI cg = this.cc.getGUI();

        cg.addFinalizeChatMessge(m);

    }
}
