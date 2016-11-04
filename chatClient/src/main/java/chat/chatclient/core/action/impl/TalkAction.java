package chat.chatclient.core.action.impl;

import chat.chatclient.ChatClient;
import chat.chatclient.GUI;
import chat.chatclient.core.action.Action;
import chat.core.message.impl.TalkMessage;
import chat.entity.Usuario;

/**
 *
 * @author rafael
 */
public class TalkAction extends Action<TalkMessage> {

    public TalkAction(ChatClient cc, TalkMessage m) {
        super(cc, m);
    }

    @Override
    public void execute() throws Exception {

        Usuario u = this.cc.getUsuario();

        GUI cg = this.cc.getGUI();


        if (this.m.getChat() == null) {
            if (!u.equals(m.getUsuario())) {
                cg.addTalkMessageGlobal(m);
            }
        } else {
            cg.addTalkMessageChat(m);
        }

    }
}
