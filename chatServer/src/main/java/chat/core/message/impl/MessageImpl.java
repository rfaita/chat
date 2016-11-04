package chat.core.message.impl;

import java.io.Serializable;
import java.util.Date;
import chat.core.message.Message;
import chat.entity.Usuario;
import chat.util.JSONUtil;

public class MessageImpl implements Message, Serializable {

    protected String type;
    protected Usuario usuario;
    protected Long time = new Date().getTime();

    public MessageImpl() {
    }

    public MessageImpl(String type, Usuario usuario) {
        this();
        this.type = type;
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "MessageImpl{" + "type=" + type + ", usuario=" + usuario + ", time=" + time + '}';
    }

    @Override
    public String asJSON() throws Exception {
        return JSONUtil.toJSON(this);

    }

    static public Object asMessage(String s) throws Exception {
        MessageImpl m = (MessageImpl) JSONUtil.toObject(s, MessageImpl.class);
        return JSONUtil.toObject(s, Class.forName(m.getType()));

    }

    public Long getTime() {
        return time;
    }

    public Date getDate() {
        return new Date(time);
    }

    public void setDate(Date time) {
        this.time = time.getTime();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
