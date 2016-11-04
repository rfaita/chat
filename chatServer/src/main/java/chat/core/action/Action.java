package chat.core.action;

import chat.core.connection.Connection;
import chat.core.message.Message;

abstract public class Action<T extends Message> {

    protected Connection c;
    protected T m;

    public Action() {
    }

    public Action(Connection c) {
        this.c = c;
    }

    public Action(Connection c, T m) {
        this.c = c;
        this.m = m;
    }

    public Connection getCon() {
        return c;
    }

    public void setCon(Connection c) {
        this.c = c;
    }

    public T getMessage() {
        return m;
    }

    public void setMessage(T m) {
        this.m = m;
    }

    abstract public void execute() throws Exception;
}
