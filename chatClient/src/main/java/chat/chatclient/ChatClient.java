package chat.chatclient;

import chat.chatclient.core.thread.ThreadOnMessageClient;
import chat.core.connection.Connection;
import chat.core.connection.impl.ConnectionImpl;
import chat.core.message.impl.*;
import chat.core.thread.ThreadMessage;
import chat.entity.ChatRoom;
import chat.entity.Usuario;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.List;

public class ChatClient {

    private Connection c;
    private ThreadMessage tm;
    private ThreadOnMessageClient tom;
    private Usuario usuario;
    private ChatRoom chatRoomAtual;
    private List<Usuario> usuariosOnline;
    private GUI gui;

    public ChatClient(GUI gui) {
        this.gui = gui;
    }

    public ChatRoom getChatRoomAtual() {
        return chatRoomAtual;
    }

    public void setChatRoomAtual(ChatRoom chatRoomAtual) {
        this.chatRoomAtual = chatRoomAtual;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getUsuariosOnline() {
        return usuariosOnline;
    }

    public void setUsuariosOnline(List<Usuario> usuariosOnline) {
        this.usuariosOnline = usuariosOnline;
    }

    public GUI getGUI() {
        return gui;
    }

    public void setGUI(GUI gui) {
        this.gui = gui;
    }

    public void connect(String endereco, int porta) throws UnknownHostException, IOException {
        c = ConnectionImpl.getConnection(endereco, porta);
        tm = new ThreadMessage(c);
        tom = new ThreadOnMessageClient(this);
        tm.start();
        tom.start();
        tom.setPriority(Thread.MAX_PRIORITY);
    }

    public void sendConnectMessage() {
        setUsuario(null);
        Usuario u = new Usuario();
        u.setNome(ChatGUI.SENHA);
        tm.send(new ConnectionMessage(u));
    }

    public void sendDisconnectMessage() {
        tm.send(new DisconnectMessage(getUsuario()));
    }

    public void sendInitiatedChatMessage() {
        tm.send(new InitiatedChatMessage(getUsuario(), null));
    }

    public void sendConnectedUserMessage() {
        tm.send(new ConnectedUserMessage(getUsuario(), null));
    }

    public void sendPingMessage() {
        tm.send(new PingMessage(getUsuario()));
    }

    public void disconnect() throws IOException {
        tm.interrupt();
        tom.interrupt();
        if (c != null) {
            c.disconnect();
        }
    }

    public void sendFinalizeChatMessage() {
        tm.send(new FinalizeChatMessage(getUsuario(), getChatRoomAtual()));
    }

    public void sendInitiateChatMessage(int idSAC) {
        ChatRoom cr = new ChatRoom();
        cr.setIdSAC(idSAC);
        tm.send(new InitiateChatMessage(getUsuario(), cr));
    }

    public void sendDisconnectChatMessage() {
        tm.send(new DisconnectChatMessage(getUsuario(), getChatRoomAtual()));
    }

    public void sendConnectionChatMessage(ChatRoom cr) {
        tm.send(new ConnectionChatMessage(getUsuario(), cr));
    }

    public void sendInviteChatMessage(Usuario uD) {
        tm.send(new InviteChatMessage(getUsuario(), getChatRoomAtual(), uD));
    }

    public void sendTalkMessage(String msg) {
        tm.send(new TalkMessage(getUsuario(), null, msg));
    }

    public void sendTalkMessageToChat(String msg) {
        if (getChatRoomAtual() != null) {
            tm.send(new TalkMessage(getUsuario(), getChatRoomAtual(), msg));
        }
    }

    public Connection getConnection() {
        return c;
    }
}
