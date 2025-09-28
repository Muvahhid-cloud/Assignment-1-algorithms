package edu.ait.recursion;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UtilTest {
    @Test
    public void testSwap() {
        int[] arr = {1, 2, 3};
        QuickSort.sort(arr); // indirectly uses swap
        assertArrayEquals(new int[]{1,2,3}, arr);
    }
}
