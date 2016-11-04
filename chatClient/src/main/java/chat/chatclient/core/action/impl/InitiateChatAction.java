package chat.chatclient.core.action.impl;

import chat.chatclient.ChatClient;
import chat.chatclient.GUI;
import chat.chatclient.core.action.Action;
import chat.core.message.impl.ConnectionChatMessage;
import chat.core.message.impl.InitiateChatMessage;

/**
 *
 * @author rafael
 */
public class InitiateChatAction extends Action<InitiateChatMessage> {

    public InitiateChatAction(ChatClient cc, InitiateChatMessage m) {
        super(cc, m);
    }

    @Override
    public void execute() throws Exception {


        GUI cg = this.cc.getGUI();

        cg.addChat(m.getChat());

        ConnectionChatMessage cm = new ConnectionChatMessage(m.getUsuario(), m.getChat());

        cg.addConnectionChatMessage(cm);

    }
}
