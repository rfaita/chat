package chat.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rafael
 */
public class ChatRoom implements Serializable {

    private int id;
    private String nome;
    private int idSAC;
    private List<Usuario> usuarios = new ArrayList<Usuario>();
    private List<Usuario> usuariosOffline = new ArrayList<Usuario>();
    private List<String> history = new ArrayList<String>();
    private boolean open = false;
    private boolean closable = true;

    public ChatRoom() {
    }

    public ChatRoom(int id, String nome, int idSAC) {
        this.id = id;
        this.nome = nome;
        this.idSAC = idSAC;
    }

    public boolean isClosable() {
        return closable;
    }

    public void setClosable(boolean closable) {
        this.closable = closable;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<String> getHistory() {
        return history;
    }

    public void setHistory(List<String> history) {
        this.history = history;
    }

    public List<Usuario> getUsuariosOffline() {
        return usuariosOffline;
    }

    public void setUsuariosOffline(List<Usuario> usuariosOffline) {
        this.usuariosOffline = usuariosOffline;
    }

    public int getIdSAC() {
        return idSAC;
    }

    public void setIdSAC(int idSAC) {
        this.idSAC = idSAC;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ChatRoom other = (ChatRoom) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.id;
        return hash;
    }

    @Override
    public String toString() {
        return "ChatRoom{" + "id=" + id + ", nome=" + nome + ", idSAC=" + idSAC + ", usuarios=" + usuarios + ", usuariosOffline=" + usuariosOffline + ", history=" + history + ", open=" + open + '}';
    }
    
    public static ChatRoom newCleanChatRoom(ChatRoom cr) {
        return new ChatRoom(cr.getId(), cr.getNome(), cr.getIdSAC());
    }
}
