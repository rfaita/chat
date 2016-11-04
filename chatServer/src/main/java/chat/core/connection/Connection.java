package chat.core.connection;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.UnknownHostException;

public interface Connection {

    void connect(String host, int port) throws UnknownHostException, IOException;

    void disconnect() throws IOException;

    boolean isClosed();

    DataOutputStream getOutputStream() throws IOException;

    DataInputStream getInputStream() throws IOException;

    String getIP();

    int getPort();
}
