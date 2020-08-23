import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BitMaskTest {
    @Test
    public void test0to60() {
        BitMask mask = new BitMask();
        testGetAndSet(mask, 10);
        assertFalse(mask.get(63));
    }

    @Test
    public void test64to128() {
        BitMask mask = new BitMask();
        testGetAndSet(mask, 80);
    }

    @Test
    public void test128to192() {
        BitMask mask = new BitMask();
        testGetAndSet(mask, 180);
    }

    @Test
    public void test192to256() {
        BitMask mask = new BitMask();
        testGetAndSet(mask, 200);
    }

    @Test
    public void testMultipleSetsOddPosition() {
        testMultiplePositionsTill200(2);
        testMultiplePositionsTill200(3);
        testMultiplePositionsTill200(5);
        testMultiplePositionsTill200(7);
    }

    private void testGetAndSet(BitMask mask, int bit) {
        assertFalse(mask.get(bit));
        mask.setTrue(bit);
        assertTrue(mask.get(bit));
    }

    private void testMultiplePositionsTill200(int mod) {
        BitMask mask = new BitMask();
        for (int i = 0; i < 200; i++) {
            if (i % mod == 0) {
                mask.setTrue(i);
            }
        }
        for (int i = 0; i < 200; i++) {
            if (i % mod != 0) {
                assertFalse(mask.get(i));
            } else {
                assertTrue(mask.get(i));
            }
        }
    }

    @Test
    public void test3() {
        BitMask mask = new BitMask();
        assertFalse(mask.get(1));
        mask.setTrue(33);
        assertFalse(mask.get(1));

    }
}
