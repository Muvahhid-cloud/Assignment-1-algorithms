package edu.ait.recursion;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

public class QuickSortTest {
    @Test
    public void testQuickSortRandom() {
        int[] arr = {9, 1, 5, 3, 8, 2};
        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        QuickSort.sort(arr);
        assertArrayEquals(sorted, arr);
    }

    @Test
    public void testWithDuplicates() {
        int[] arr = {4, 4, 4, 2, 1};
        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        QuickSort.sort(arr);
        assertArrayEquals(sorted, arr);
    }
}
