package com.abhishek.algorithms.davincicode.sorting.countingsort;

import java.util.Arrays;

/**
 * Given an array of N number and Value K, Such that an array consists of number between 0 to K-1.
 * Ex- I/P arr={4,4,0,1,1,2}, K=5 O/P={0,1,1,2,4,4}
 *
 * @author abhishek
 */
public class CountingSort {

    public static void main(String[] args) {
        int[] arr = {4, 4, 0, 1, 1, 2};
        int n = arr.length;
        int k = 5;
        countingSortNaive(arr, n, k);
        System.out.println(Arrays.toString(arr));
        int[] arr1 = {4, 4, 0, 1, 1, 2};
        int k1 = 5;
        countingSortOptimised(arr1, k1);
        System.out.println(Arrays.toString(arr1));
    }

    /**
     * Time complexity: O(n+k) Aux Space: O(k)
     *
     * @param arr
     * @param n
     * @param k
     */
    public static void countingSortNaive(int[] arr, int n, int k) {
        // The input array will always have k-1 elements which means the maximum element
        // in the array might be k-1
        int[] count = new int[k];
        // Populate the count array and update the count of each element in the input
        // array
        for (int i = 0; i < n; i++)
            count[arr[i]] += 1;
        // Now, we will overwrite the array
        int index = 0;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < count[i]; j++)
                arr[index++] = i;
        }
    }

    public static void countingSortOptimised(int n[], int k) {
        int N = n.length;
        int count[] = new int[k];
        for (int i = 0; i < n.length; i++) {
            count[n[i]] = count[n[i]] + 1;
        }
        for (int i = 1; i < k; i++) {
            count[i] = count[i] + count[i - 1];
        }
        int output[] = new int[N];
        for (int i = N - 1; i >= 0; i--) {
            output[count[n[i]] - 1] = n[i];
            count[n[i]]--;
        }
        for (int i = 0; i < N; i++) {
            n[i] = output[i];
        }
    }

}
