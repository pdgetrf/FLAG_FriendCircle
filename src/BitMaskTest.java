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
        //testMultiplePositions(2);
        testMultiplePositions(3);
    }

    private void testGetAndSet(BitMask mask, int bit) {
        assertFalse(mask.get(bit));
        mask.setTrue(bit);
        assertTrue(mask.get(bit));
    }

    private void testMultiplePositions(int mod) {
        BitMask mask = new BitMask();
        for (int i = 0; i < 240; i++) {
            if (i % mod == 0) {
                System.out.println(i + " " + mask.get(1) + ",");
                mask.setTrue(i);
            }
        }
        System.out.println("\n");

        for (int i = 0; i < 240; i++) {
            if (i % mod != 0) {
                System.out.println("i = " + i + " expecting false, actual " + mask.get(i));
                assertFalse(mask.get(i));
            } else {
                System.out.println("i = " + i + " expecting true");
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
