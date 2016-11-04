package chat.core.message.impl;

import java.io.Serializable;
import java.util.List;
import chat.core.message.Message;
import chat.entity.ChatRoom;
import chat.entity.Usuario;

/**
 *
 * @author rafael
 */
public class InitiatedChatMessage extends MessageImpl implements Message, Serializable {

    protected List<ChatRoom> chats;

    public InitiatedChatMessage() {
    }

    public InitiatedChatMessage(Usuario usuario, List<ChatRoom> chats) {
        super(InitiatedChatMessage.class.getName(), usuario);
        this.chats = chats;
    }

    public List<ChatRoom> getChats() {
        return chats;
    }

    public void setChats(List<ChatRoom> chats) {
        this.chats = chats;
    }

    @Override
    public String toString() {
        return "InitiatedChatMessage{" + super.toString() + "chats=" + chats + '}';
    }
}
