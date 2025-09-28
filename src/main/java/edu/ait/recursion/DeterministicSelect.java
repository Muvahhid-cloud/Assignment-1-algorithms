package edu.ait.recursion;

import java.util.Arrays;

public class DeterministicSelect {
    public static int select(int[] arr, int k) {
        return select(arr, 0, arr.length - 1, k);
    }

    private static int select(int[] arr, int lo, int hi, int k) {
        if (lo == hi) return arr[lo];
        int pivot = medianOfMedians(arr, lo, hi);
        int pivotIndex = partition(arr, lo, hi, pivot);
        int rank = pivotIndex - lo + 1;
        if (k == rank) return arr[pivotIndex];
        else if (k < rank) return select(arr, lo, pivotIndex - 1, k);
        else return select(arr, pivotIndex + 1, hi, k - rank);
    }

    private static int medianOfMedians(int[] arr, int lo, int hi) {
        int n = hi - lo + 1;
        if (n < 5) {
            Arrays.sort(arr, lo, hi + 1);
            return arr[lo + n / 2];
        }
        int groups = (int) Math.ceil((double) n / 5);
        int[] medians = new int[groups];
        for (int i = 0; i < groups; i++) {
            int gLo = lo + i * 5;
            int gHi = Math.min(gLo + 4, hi);
            Arrays.sort(arr, gLo, gHi + 1);
            medians[i] = arr[gLo + (gHi - gLo) / 2];
        }
        return select(medians, 0, groups - 1, groups / 2 + 1);
    }

    private static int partition(int[] arr, int lo, int hi, int pivot) {
        int pivotIndex = lo;
        for (int i = lo; i <= hi; i++) if (arr[i] == pivot) { pivotIndex = i; break; }
        swap(arr, pivotIndex, hi);
        int i = lo;
        for (int j = lo; j < hi; j++) {
            if (arr[j] < pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, hi);
        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i]; arr[i] = arr[j]; arr[j] = tmp;
    }
}
