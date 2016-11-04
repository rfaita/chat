package chat.chatclient.core.action;

import chat.chatclient.ChatClient;
import chat.core.message.Message;

abstract public class Action<T extends Message> {

    protected T m;
    protected ChatClient cc;

    public Action() {
    }

    public Action(ChatClient cc, T m) {
        this.cc = cc;
        this.m = m;
    }

    public T getMessage() {
        return m;
    }

    public void setMessage(T m) {
        this.m = m;
    }

    public ChatClient getChatClient() {
        return cc;
    }

    public void setChatClient(ChatClient chatClient) {
        this.cc = chatClient;
    }

    abstract public void execute() throws Exception;
}
