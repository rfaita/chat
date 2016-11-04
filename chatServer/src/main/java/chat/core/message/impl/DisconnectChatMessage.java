package chat.core.message.impl;

import java.io.Serializable;
import chat.core.message.Message;
import chat.entity.ChatRoom;
import chat.entity.Usuario;

/**
 *
 * @author rafael
 */
public class DisconnectChatMessage extends MessageImpl implements Message, Serializable {

    protected ChatRoom chat;

    public DisconnectChatMessage() {
    }

    public DisconnectChatMessage(Usuario usuario, ChatRoom chat) {
        super(DisconnectChatMessage.class.getName(), usuario);
        this.chat = chat;
    }

    public ChatRoom getChat() {
        return chat;
    }

    public void setChat(ChatRoom chat) {
        this.chat = chat;
    }

    @Override
    public String toString() {
        return "DisconnectChatMessage{" + super.toString() + "chat=" + chat + '}';
    }
}
