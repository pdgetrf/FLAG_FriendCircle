public class BitMask {
    private long[] bits = new long[4];
    public int MAX_SIZE = 256;

    public void setTrue(int bit) {
        if (bit >= 0 && bit < 60) {
            bits[0] |= ((long) 1 << bit);
            return;
        }
        if (bit >= 60 && bit < 120) {
            bits[1] |= ((long) 1 << (bit - 60));
            return;
        }
        if (bit >= 120 && bit < 180) {
            bits[2] |= ((long) 1 << (bit - 120));
            return;
        }
        if (bit >= 180 && bit < 240) {
            bits[3] |= ((long) 1 << (bit - 180));
            return;
        }
    }

    public boolean get(int bit) {
        if (bit >= 0 && bit < 60) {
            return (bits[0] & ((long) 1 << bit)) > 0;
        }
        if (bit >= 60 && bit < 120) {
            return (bits[1] & ((long) 1 << (bit - 60))) > 0;
        }
        if (bit >= 120 && bit < 180) {
            return (bits[2] & ((long) 1 << (bit - 120))) > 0;
        }
        if (bit >= 180 && bit < 240) {
            return (bits[3] & ((long) 1 << (bit - 180))) > 0;
        }
        return false;
    }
}
