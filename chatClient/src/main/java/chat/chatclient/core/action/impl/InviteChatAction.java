package chat.chatclient.core.action.impl;

import chat.chatclient.ChatClient;
import chat.chatclient.GUI;
import chat.chatclient.core.action.Action;
import chat.core.message.impl.InviteChatMessage;

/**
 *
 * @author rafael
 */
public class InviteChatAction extends Action<InviteChatMessage> {

    public InviteChatAction(ChatClient cc, InviteChatMessage m) {
        super(cc, m);
    }

    @Override
    public void execute() throws Exception {


        GUI cg = this.cc.getGUI();

        if (cg.acceptInvite(m.getChat().getNome(), m.getUsuario().getNome())) {
            if (cc.getChatRoomAtual() != null) {
                cc.sendDisconnectChatMessage();
            }
            cc.sendConnectionChatMessage(m.getChat());
        }


    }
}
