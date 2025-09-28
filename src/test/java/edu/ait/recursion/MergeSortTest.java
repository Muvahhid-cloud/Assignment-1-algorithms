package edu.ait.recursion;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

public class MergeSortTest {
    @Test
    public void testMergeSortRandom() {
        int[] arr = {5, 3, 8, 1, 2, 7};
        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        MergeSort.sort(arr);
        assertArrayEquals(sorted, arr);
    }

    @Test
    public void testAlreadySorted() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] sorted = arr.clone();
        MergeSort.sort(arr);
        assertArrayEquals(sorted, arr);
    }

    @Test
    public void testEmptyArray() {
        int[] arr = {};
        MergeSort.sort(arr);
        assertEquals(0, arr.length);
    }
}
