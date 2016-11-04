package chat.core.message.impl;

import java.io.Serializable;
import chat.core.message.Message;
import chat.entity.Usuario;

public class ConnectionMessage extends MessageImpl implements Message, Serializable {

    public ConnectionMessage() {
    }

    public ConnectionMessage(Usuario usuario) {
        super(ConnectionMessage.class.getName(), usuario);
    }

    @Override
    public String toString() {
        return "ConnectionMessage{" + super.toString() + '}';
    }
}
