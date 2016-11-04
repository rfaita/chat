package chat.util;

import java.math.BigInteger;
import java.security.MessageDigest;

public class MD5Util {

    public static String md5(String str) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        BigInteger hash = new BigInteger(1, md.digest(str.getBytes()));
        return hash.toString(16);
    }
}
