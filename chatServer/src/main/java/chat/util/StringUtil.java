package chat.util;

import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringUtil {

    private static final SimpleDateFormat FORMAT_DATE_HOUR = new SimpleDateFormat("dd/MM hh:mm:ss");

    static public String bytesToString(byte[] b, int i, int f) {

        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        bos.write(b, i, f);

        return new String(bos.toByteArray());
    }

    static public String formatDateHour(Date d) throws  Exception {
        return FORMAT_DATE_HOUR.format(d);
    }
}
