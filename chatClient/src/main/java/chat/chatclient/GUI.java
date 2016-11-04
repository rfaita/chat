package chat.chatclient;

import chat.core.message.impl.*;
import chat.entity.ChatRoom;
import chat.entity.Usuario;

/**
 *
 * @author rafael
 */
public interface GUI {

    void addChat(ChatRoom cr);

    void addConnectionChatMessage(ConnectionChatMessage m) throws Exception;

    void addConnectionMessage(ConnectionMessage m) throws Exception;

    void addDisconnectChatMessage(DisconnectChatMessage m) throws Exception;

    void addDisconnectMessage(DisconnectMessage m) throws Exception;

    void addFinalizeChatMessge(FinalizeChatMessage m) throws Exception;

    void addTalkMessageChat(TalkMessage m) throws Exception;

    void addTalkMessageGlobal(TalkMessage m) throws Exception;

    void addUser(Usuario u);

    void joinChat();

    void leaveChat();

    void loadChatHistory(ConnectionChatMessage m) throws Exception;

    void refreshChat(ChatRoom cr);

    void removeChat(ChatRoom cr);

    void removeUser(Usuario u);

    void selectUser(int index);

    int getSelectedUser();

    boolean acceptInvite(String chat, String usuario);
}
