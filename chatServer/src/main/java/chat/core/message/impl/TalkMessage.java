package chat.core.message.impl;

import java.io.Serializable;
import chat.core.message.Message;
import chat.entity.ChatRoom;
import chat.entity.Usuario;

public class TalkMessage extends MessageImpl implements Message, Serializable {

    protected String talk;
    protected ChatRoom chat;

    public TalkMessage() {
    }

    public TalkMessage(Usuario usuario, ChatRoom chat, String fala) {
        super(TalkMessage.class.getName(), usuario);
        this.chat = chat;
        this.talk = fala;
    }

    @Override
    public String toString() {
        return "TalkMessage{" + super.toString() + "talk=" + talk + ", chat=" + chat + '}';
    }

    public ChatRoom getChat() {
        return chat;
    }

    public void setChat(ChatRoom chat) {
        this.chat = chat;
    }

    public String getTalk() {
        return talk;
    }

    public void setTalk(String talk) {
        this.talk = talk;
    }
}
