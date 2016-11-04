package chat;

import java.util.ArrayList;
import java.util.List;
import chat.entity.ChatRoom;
import chat.entity.Usuario;

/**
 *
 * @author rafael
 */
public class Chat {

    // <editor-fold defaultstate="collapsed" desc=" SINGLETOON ">
    private Chat() {

        ChatRoom cr = new ChatRoom();
        cr.setId(1);
        cr.setNome("LOGIC - GERAL");
        cr.setOpen(true);
        cr.setClosable(false);

        chatsRooms.add(cr);

    }
    private static Chat instance;

    public static Chat getInstance() {

        if (instance == null) {
            instance = new Chat();
        }
        return instance;
    }
    // </editor-fold>
    private List<Usuario> usuarios = new ArrayList<Usuario>();
    private List<Usuario> usuariosOffline = new ArrayList<Usuario>();
    private List<ChatRoom> chatsRooms = new ArrayList<ChatRoom>();
    private static int countChat = 2;
    private ChatStatus status = ChatStatus.NORMAL;

    public synchronized List<Usuario> getUsuarios() {
        return usuarios;
    }

    public synchronized void setUsuarios(List<Usuario> us) {
        this.usuarios = us;
    }

    public synchronized List<ChatRoom> getChatsRooms() {
        return chatsRooms;
    }

    public synchronized void setChatsRooms(List<ChatRoom> chatsRooms) {
        this.chatsRooms = chatsRooms;
    }

    public ChatRoom getChatRoom(int idChat) {

        ChatRoom c = new ChatRoom();
        c.setId(idChat);
        return getChatRoom(c);
    }

    public ChatRoom getChatRoom(ChatRoom chat) {

        if (this.chatsRooms.indexOf(chat) > -1) {
            return this.chatsRooms.get(this.chatsRooms.indexOf(chat));
        }
        return null;
    }

    public synchronized ChatRoom createChatRoom(int idSAC) {
        ChatRoom cr = new ChatRoom();
        cr.setId(countChat++);
        cr.setNome("SALA " + cr.getId());
        cr.setUsuarios(new ArrayList<Usuario>());
        cr.setIdSAC(idSAC);
        cr.setUsuariosOffline(new ArrayList<Usuario>());
        cr.setHistory(new ArrayList<String>());
        cr.setOpen(true);
        return cr;
    }

    public synchronized void destroyChatRoom(ChatRoom cr) {
        this.chatsRooms.remove(cr);
    }

    public Usuario getUsuario(int idUsuario) {

        Usuario c = new Usuario();
        c.setId(idUsuario);
        return getUsuario(c);
    }

    public Usuario getUsuario(Usuario u) {

        if (this.usuarios.indexOf(u) > -1) {
            return this.usuarios.get(this.usuarios.indexOf(u));
        }
        return null;
    }

    public List<Usuario> getUsuariosOffline() {
        return usuariosOffline;
    }

    public synchronized void setUsuariosOffline(List<Usuario> usuariosOffline) {
        this.usuariosOffline = usuariosOffline;
    }

    public synchronized ChatStatus getStatus() {
        return status;
    }

    public synchronized void setStatus(ChatStatus status) {
        this.status = status;
    }
}
