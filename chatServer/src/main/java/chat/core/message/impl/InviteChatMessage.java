package chat.core.message.impl;

import java.io.Serializable;
import chat.core.message.Message;
import chat.entity.ChatRoom;
import chat.entity.Usuario;

/**
 *
 * @author rafael
 */
public class InviteChatMessage extends MessageImpl implements Message, Serializable {

    protected ChatRoom chat;
    protected Usuario usuarioDestino;

    public InviteChatMessage() {
    }

    public InviteChatMessage(Usuario usuario, ChatRoom chat, Usuario usuarioDestino) {
        super(InviteChatMessage.class.getName(), usuario);
        this.chat = chat;
        this.usuarioDestino = usuarioDestino;
    }

    public ChatRoom getChat() {
        return chat;
    }

    public void setChat(ChatRoom chat) {
        this.chat = chat;
    }

    public Usuario getUsuarioDestino() {
        return usuarioDestino;
    }

    public void setUsuarioDestino(Usuario usuarioDestino) {
        this.usuarioDestino = usuarioDestino;
    }

    @Override
    public String toString() {
        return "InviteChatMessage{" + super.toString() + "chat=" + chat + ", usuarioDestino=" + usuarioDestino + '}';
    }
}
