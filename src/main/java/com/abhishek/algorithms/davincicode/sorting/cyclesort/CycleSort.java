package com.abhishek.algorithms.davincicode.sorting.cyclesort;

import java.util.Arrays;

public class CycleSort {

    public static void main(String[] args) {
        int[] arr = {3, 5, 1, 4, 2};
        cycleSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    public static void cycleSort(int n[], int N) {
        int swaps = 0;
        for (int i = 0; i < N; i++) {
            int element = n[i];
            int sm = smallerElements(n, element);
            if (i == sm)
                continue;
            while (i != sm) {
                // To handle duplicates
                if (n[sm] == n[i]) {
                    sm++;
                    continue;
                }
                int temp = n[sm];
                n[sm] = n[i];
                n[i] = temp;
                swaps++;
                sm = smallerElements(n, n[i]);
            }

        }
        System.out.println("Swaps : " + swaps);
    }

    private static int smallerElements(int n[], int x) {
        int count = 0;
        for (int i = 0; i < n.length; i++) {
            if (n[i] < x) {
                count++;
            }
        }
        return count;
    }

}
