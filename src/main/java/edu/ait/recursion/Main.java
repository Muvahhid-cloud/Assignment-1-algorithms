package edu.ait.recursion;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int n = 10000;
        int[] arr = new Random().ints(n, 0, n*10).toArray();

        int[] copy1 = arr.clone();
        int[] copy2 = arr.clone();

        MergeSort.sort(copy1);
        QuickSort.sort(copy2);

        System.out.println("Median via MoM: " + DeterministicSelect.select(arr.clone(), n/2));

        ClosestPair.Point[] pts = new ClosestPair.Point[n];
        Random r = new Random();
        for (int i = 0; i < n; i++) pts[i] = new ClosestPair.Point(r.nextDouble(), r.nextDouble());
        System.out.println("Closest Pair distance: " + ClosestPair.closestPair(pts));
    }
}
