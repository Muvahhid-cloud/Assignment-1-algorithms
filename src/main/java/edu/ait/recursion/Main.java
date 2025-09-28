package edu.ait.recursion;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] sizes = {100, 500, 1000, 5000, 10000}; // different input sizes
        Random rand = new Random();

        for (int n : sizes) {
            int[] arr = rand.ints(n, 0, n * 10).toArray();

            // --- MergeSort ---
            int[] copy1 = arr.clone();
            long t1 = System.nanoTime();
            MergeSort.sort(copy1);
            long t2 = System.nanoTime();
            System.out.printf("MergeSort n=%d time=%d ns%n", n, (t2 - t1));

            // --- QuickSort ---
            int[] copy2 = arr.clone();
            long t3 = System.nanoTime();
            QuickSort.sort(copy2);
            long t4 = System.nanoTime();
            System.out.printf("QuickSort n=%d time=%d ns%n", n, (t4 - t3));

            // --- Deterministic Select (Median of Medians) ---
            int k = n / 2;
            int[] copy3 = arr.clone();
            long t5 = System.nanoTime();
            int kth = DeterministicSelect.select(copy3, k);
            long t6 = System.nanoTime();
            System.out.printf("Select n=%d kth=%d result=%d time=%d ns%n",
                    n, k, kth, (t6 - t5));

            // --- Closest Pair ---
            ClosestPair.Point[] pts = new ClosestPair.Point[n];
            for (int i = 0; i < n; i++)
                pts[i] = new ClosestPair.Point(rand.nextDouble(), rand.nextDouble());

            long t7 = System.nanoTime();
            double dist = ClosestPair.closestPair(pts);
            long t8 = System.nanoTime();
            System.out.printf("ClosestPair n=%d dist=%f time=%d ns%n%n",
                    n, dist, (t8 - t7));
        }
    }
}
