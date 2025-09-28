package edu.ait.recursion;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;

public class DeterministicSelectTest {
    @Test
    public void testSmallArray() {
        int[] arr = {7, 2, 9, 1, 5};
        int k = 3; // 3rd smallest
        int expected = Arrays.stream(arr).sorted().toArray()[k - 1];
        assertEquals(expected, DeterministicSelect.select(arr, k));
    }

    @Test
    public void testLargeRandomArray() {
        Random rand = new Random();
        int[] arr = rand.ints(1000, 0, 10000).toArray();
        int k = 500;
        int expected = Arrays.stream(arr).sorted().toArray()[k - 1];
        assertEquals(expected, DeterministicSelect.select(arr.clone(), k));
    }
}
