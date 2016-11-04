package chat.core.message.impl;

import java.io.Serializable;
import chat.core.message.Message;
import chat.entity.ChatRoom;
import chat.entity.Usuario;

/**
 *
 * @author rafael
 */
public class ConnectionChatMessage extends MessageImpl implements Message, Serializable {

    protected ChatRoom chat;

    public ConnectionChatMessage() {
    }

    public ConnectionChatMessage(Usuario usuario, ChatRoom chat) {
        super(ConnectionChatMessage.class.getName(), usuario);
        this.chat = chat;
    }

    @Override
    public String toString() {
        return "ConnectionChatMessage{" + super.toString() + "chat=" + chat + '}';
    }

    public ChatRoom getChat() {
        return chat;
    }

    public void setChat(ChatRoom chat) {
        this.chat = chat;
    }
}
