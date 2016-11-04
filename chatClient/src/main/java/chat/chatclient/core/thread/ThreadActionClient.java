package chat.chatclient.core.thread;

import chat.chatclient.ChatClient;
import chat.chatclient.core.action.impl.*;
import chat.core.message.impl.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadActionClient extends Thread {

    private String s;
    private ChatClient cc;
    private static final Logger logger = Logger.getLogger(ThreadActionClient.class.getName());

    public ThreadActionClient(ChatClient cc, String s) {
        this.s = s;
        this.cc = cc;
    }

    @Override
    public void run() {
        try {


            MessageImpl o = (MessageImpl) MessageImpl.asMessage(s);

            String type = o.getType();


            if (type.equals(ConnectionMessage.class.getName())) {
                new ConnectionAction(cc, (ConnectionMessage) o).execute();
            } else if (type.equals(DisconnectMessage.class.getName())) {
                new DisconnectAction(cc, (DisconnectMessage) o).execute();
            } else if (type.equals(ConnectedUserMessage.class.getName())) {
                new ConnectedUserAction(cc, (ConnectedUserMessage) o).execute();
            } else if (type.equals(ConnectionChatMessage.class.getName())) {
                new ConnectionChatAction(cc, (ConnectionChatMessage) o).execute();
            } else if (type.equals(DisconnectChatMessage.class.getName())) {
                new DisconnectChatAction(cc, (DisconnectChatMessage) o).execute();
            } else if (type.equals(TalkMessage.class.getName())) {
                new TalkAction(cc, (TalkMessage) o).execute();
            } else if (type.equals(InitiateChatMessage.class.getName())) {
                (new InitiateChatAction(cc, (InitiateChatMessage) o)).execute();
            } else if (type.equals(InitiatedChatMessage.class.getName())) {
                new InitiatedChatAction(cc, (InitiatedChatMessage) o).execute();
            } else if (type.equals(FinalizeChatMessage.class.getName())) {
                new FinalizeChatAction(cc, (FinalizeChatMessage) o).execute();
            } else if (type.equals(InviteChatMessage.class.getName())) {
                new InviteChatAction(cc, (InviteChatMessage) o).execute();
            } else if (type.equals(RefreshChatMessage.class.getName())) {
                new RefreshChatAction(cc, (RefreshChatMessage) o).execute();
            } else {
                System.out.println("CLIENT -> " + o.getType());
            }



        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Problemas ao executar messangem.", ex);
        }
    }

    public static ThreadActionClient newActionClient(ChatClient cc, String s) {
        return new ThreadActionClient(cc, s);
    }
}
