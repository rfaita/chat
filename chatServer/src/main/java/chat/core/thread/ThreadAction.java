package chat.core.thread;

import chat.core.message.impl.DisconnectMessage;
import chat.core.message.impl.InitiatedChatMessage;
import chat.core.message.impl.PingMessage;
import chat.core.message.impl.InviteChatMessage;
import chat.core.message.impl.MessageImpl;
import chat.core.message.impl.DisconnectChatMessage;
import chat.core.message.impl.TalkMessage;
import chat.core.message.impl.InitiateChatMessage;
import chat.core.message.impl.ConnectionMessage;
import chat.core.message.impl.RefreshChatMessage;
import chat.core.message.impl.ConnectionChatMessage;
import chat.core.message.impl.ConnectedUserMessage;
import chat.core.message.impl.FinalizeChatMessage;
import chat.core.action.impl.TalkAction;
import chat.core.action.impl.DisconnectAction;
import chat.core.action.impl.DisconnectChatAction;
import chat.core.action.impl.ConnectionChatAction;
import chat.core.action.impl.RefreshChatAction;
import chat.core.action.impl.FinalizeChatAction;
import chat.core.action.impl.InitiateChatAction;
import chat.core.action.impl.PingAction;
import chat.core.action.impl.ConnectionAction;
import chat.core.action.impl.InitiatedChatAction;
import chat.core.action.impl.ConnectedUserAction;
import chat.core.action.impl.InviteChatAction;
import java.util.logging.Level;
import java.util.logging.Logger;
import chat.core.connection.Connection;

public class ThreadAction extends Thread {
    
    private String s;
    private Connection c;
    private static final Logger logger = Logger.getLogger(ThreadAction.class.getName());
    
    public ThreadAction(Connection c, String s) {
        this.c = c;
        this.s = s;
    }
    
    @Override
    public void run() {
        try {
            
            MessageImpl o = (MessageImpl) MessageImpl.asMessage(s);
            
            String type = o.getType();
            
            logger.log(Level.INFO, "MSG CLIENT -> SERVER: {0}", s);
            
            if (type.equals(TalkMessage.class.getName())) {
                (new TalkAction(c, (TalkMessage) o)).execute();
            } else if (type.equals(ConnectionMessage.class.getName())) {
                (new ConnectionAction(c, (ConnectionMessage) o)).execute();
            } else if (type.equals(ConnectedUserMessage.class.getName())) {
                (new ConnectedUserAction(c, (ConnectedUserMessage) o)).execute();
            } else if (type.equals(DisconnectMessage.class.getName())) {
                (new DisconnectAction(c, (DisconnectMessage) o)).execute();
            } else if (type.equals(InitiateChatMessage.class.getName())) {
                (new InitiateChatAction(c, (InitiateChatMessage) o)).execute();
            } else if (type.equals(ConnectionChatMessage.class.getName())) {
                (new ConnectionChatAction(c, (ConnectionChatMessage) o)).execute();
            } else if (type.equals(DisconnectChatMessage.class.getName())) {
                (new DisconnectChatAction(c, (DisconnectChatMessage) o)).execute();
            } else if (type.equals(FinalizeChatMessage.class.getName())) {
                (new FinalizeChatAction(c, (FinalizeChatMessage) o)).execute();
            } else if (type.equals(InitiatedChatMessage.class.getName())) {
                (new InitiatedChatAction(c, (InitiatedChatMessage) o)).execute();
            } else if (type.equals(InviteChatMessage.class.getName())) {
                (new InviteChatAction(c, (InviteChatMessage) o)).execute();
            } else if (type.equals(RefreshChatMessage.class.getName())) {
                (new RefreshChatAction(c, (RefreshChatMessage) o)).execute();
            } else if (type.equals(PingMessage.class.getName())) {
                (new PingAction(c, (PingMessage) o)).execute();
            } else {
                throw new UnsupportedOperationException("Mensagem não suportada.");
            }
            
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Problemas ao executar messangem." + s, ex);
        }
    }
    
    public static ThreadAction newAction(Connection c, String s) {
        return new ThreadAction(c, s);
    }
}
