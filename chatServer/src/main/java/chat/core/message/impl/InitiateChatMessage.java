package chat.core.message.impl;

import java.io.Serializable;
import chat.core.message.Message;
import chat.entity.ChatRoom;
import chat.entity.Usuario;

/**
 *
 * @author rafael
 */
public class InitiateChatMessage extends MessageImpl implements Message, Serializable {

    protected ChatRoom chat;

    public InitiateChatMessage() {
    }

    public InitiateChatMessage(Usuario usuario, ChatRoom chat) {
        super(InitiateChatMessage.class.getName(), usuario);
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
        return "InitiateChatMessage{" + super.toString() + "chat=" + chat + '}';
    }
}
