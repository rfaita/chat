package chat.core.message.impl;

import java.io.Serializable;
import chat.core.message.Message;
import chat.entity.Usuario;

public class DisconnectMessage extends MessageImpl implements Message, Serializable {

    public DisconnectMessage() {
    }

    public DisconnectMessage(Usuario usuario) {
        super(DisconnectMessage.class.getName(), usuario);
    }

    @Override
    public String toString() {
        return "DisconnectMessage{" + super.toString() + '}';
    }
}
