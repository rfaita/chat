package chat.util;

public class NumberUtil {

    private static final int MASK = 0xff;

    public static byte[] intToBytes(int i) {
        return new byte[]{
                    (byte) (i >>> 24),
                    (byte) (i >>> 16),
                    (byte) (i >>> 8),
                    (byte) i,};
    }

    public static int bytesToInt(byte[] b) {
        int i = 0;
        i |= b[0] & MASK;
        i <<= 8;
        i |= b[1] & MASK;
        i <<= 8;
        i |= b[2] & MASK;
        i <<= 8;
        i |= b[3] & MASK;
        return i;
    }

    public static byte[] floatToBytes(float f) {
        return intToBytes(Float.floatToRawIntBits(f));
    }

    public static float bytesToFloat(byte[] b) {
        return Float.intBitsToFloat(bytesToInt(b));
    }

    public static byte[] shortToBytes(short s) {
        return new byte[]{
                    (byte) (s >>> 8),
                    (byte) s,};
    }

    public static short bytesToShort(byte[] b) {
        short s = 0;
        s |= b[0] & MASK;
        s <<= 8;
        s |= b[1] & MASK;
        return s;
    }

    public static byte[] longToBytes(long l) {
        return new byte[]{
                    (byte) (l >>> 56),
                    (byte) (l >>> 48),
                    (byte) (l >>> 40),
                    (byte) (l >>> 32),
                    (byte) (l >>> 24),
                    (byte) (l >>> 16),
                    (byte) (l >>> 8),
                    (byte) l,};
    }

    public static long bytesToLong(byte[] b) {
        long l = 0;
        l |= b[0] & MASK;
        l <<= 8;
        l |= b[1] & MASK;
        l <<= 8;
        l |= b[2] & MASK;
        l <<= 8;
        l |= b[3] & MASK;
        l <<= 8;
        l |= b[4] & MASK;
        l <<= 8;
        l |= b[5] & MASK;
        l <<= 8;
        l |= b[6] & MASK;
        l <<= 8;
        l |= b[7] & MASK;
        return l;

    }
}
