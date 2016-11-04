package chat.core.message.impl;

import java.io.Serializable;
import chat.core.message.Message;
import chat.entity.ChatRoom;
import chat.entity.Usuario;

/**
 *
 * @author rafael
 */
public class RefreshChatMessage extends MessageImpl implements Message, Serializable {

    protected ChatRoom chat;

    public RefreshChatMessage() {
    }

    public RefreshChatMessage(Usuario usuario, ChatRoom chat) {
        super(RefreshChatMessage.class.getName(), usuario);
        this.chat = chat;
    }

    @Override
    public String toString() {
        return "RefreshChatMessage{" + super.toString() + "chat=" + chat + '}';
    }

    public ChatRoom getChat() {
        return chat;
    }

    public void setChat(ChatRoom chat) {
        this.chat = chat;
    }
}
