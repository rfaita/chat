package chat.core.message.impl;

import java.io.Serializable;
import chat.core.message.Message;
import chat.entity.Usuario;

public class PingMessage extends MessageImpl implements Message, Serializable {

    public PingMessage() {
    }

    public PingMessage(Usuario usuario) {
        super(PingMessage.class.getName(), usuario);
    }

    @Override
    public String toString() {
        return "PingMessage{" + super.toString() + '}';
    }
}
