package chat.core.message;

import java.io.Serializable;

/**
 * @author Rafael
 *
 */
public interface Message extends Serializable {

    public final static int LENGTH_SIZE = 2;
    public final static int MAX_LENGTH = Short.MAX_VALUE;

    String asJSON() throws Exception;
}
