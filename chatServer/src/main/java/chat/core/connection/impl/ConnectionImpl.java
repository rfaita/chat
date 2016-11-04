package chat.core.connection.impl;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import chat.core.connection.Connection;

public class ConnectionImpl implements Connection {

    private Socket s;
    private DataInputStream dis;
    private DataOutputStream dos;

    public ConnectionImpl(Socket s) {
        this.s = s;
    }

    public ConnectionImpl(String host, int port) throws UnknownHostException, IOException {
        this.s = new Socket(host, port);
    }

    @Override
    public void connect(String host, int port) throws UnknownHostException, IOException {
        this.s = new Socket(host, port);
    }

    @Override
    public void disconnect() throws IOException {
        if (dis != null) {
            dis.close();
        }
        if (dos != null) {
            dos.close();
        }
        this.s.close();

    }

    @Override
    public String getIP() {
        return this.s.getInetAddress().getHostAddress();
    }

    @Override
    public DataInputStream getInputStream() throws IOException {
        if (dis == null) {
            dis = new DataInputStream(this.s.getInputStream());
        }
        return dis;
    }

    @Override
    public DataOutputStream getOutputStream() throws IOException {
        if (dos == null) {
            dos = new DataOutputStream(this.s.getOutputStream());;
        }
        return dos;
    }

    static public Connection getConnection(String host, int port) throws UnknownHostException, IOException {
        return new ConnectionImpl(host, port);
    }

    static public Connection getConnection(Socket s) {
        return new ConnectionImpl(s);
    }

    @Override
    public boolean isClosed() {
        return this.s.isClosed();
    }

    @Override
    public int getPort() {
        return s.getPort();
    }
}
