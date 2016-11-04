package chat.core.message.impl;

import java.io.Serializable;
import chat.core.message.Message;
import chat.entity.ChatRoom;
import chat.entity.Usuario;

/**
 *
 * @author rafael
 */
public class FinalizeChatMessage extends MessageImpl implements Message, Serializable {

    protected ChatRoom chat;

    public FinalizeChatMessage() {
    }

    public FinalizeChatMessage(Usuario usuario, ChatRoom chat) {
        super(FinalizeChatMessage.class.getName(), usuario);
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
        return "FinalizeChatMessage{" + super.toString() + "chat=" + chat + '}';
    }
}
