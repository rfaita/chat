package chat.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @author rafael
 */
public class JSONUtil {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    static {
        MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public static String toJSON(Object a) throws Exception {
        return MAPPER.writeValueAsString(a);
    }

    public static Object toObject(String s, Class c) throws Exception {
        return MAPPER.readValue(s, c);
    }
}
