package chat.core.message.impl;

import java.io.Serializable;
import java.util.List;
import chat.core.message.Message;
import chat.entity.Usuario;

public class ConnectedUserMessage extends MessageImpl implements Message, Serializable {

    protected List<Usuario> usuarios;

    public ConnectedUserMessage() {
    }

    public ConnectedUserMessage(Usuario usuario, List<Usuario> usuarios) {
        super(ConnectedUserMessage.class.getName(), usuario);
        this.usuarios = usuarios;
    }

    @Override
    public String toString() {
        return "ConnectedUserMessage{" + super.toString() + "usuarios=" + usuarios + '}';
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
