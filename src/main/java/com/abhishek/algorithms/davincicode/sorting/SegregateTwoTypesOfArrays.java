package com.abhishek.algorithms.davincicode.sorting;

import java.util.Arrays;

/**
 * It's a similar question to sort binary array In this code,we are going to discuss two methods
 * Bruteforce and Partitioning based solution
 *
 * @author abhishek
 */
public class SegregateTwoTypesOfArrays {

    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 0, 1, 0, 1, 0};
        segregateNaive(arr, arr.length);
        System.out.println(Arrays.toString(arr));
        int[] arr1 = {1, 0, 1, 0, 1, 0, 1, 0};
        segregatePartitionBased(arr1, arr1.length);
        System.out.println(Arrays.toString(arr1));
    }

    /**
     * Bruteforce approach O(n): Aux space O(n): Time complexity
     *
     * @param arr
     * @param n
     */
    public static void segregateNaive(int[] arr, int n) {
        int countZeros = 0;
        for (int i = 0; i < n; i++)
            if (arr[i] == 0)
                countZeros++;
        for (int i = 0; i < n; i++) {
            if (countZeros > 0) {
                arr[i] = 0;
                countZeros--;
            } else {
                arr[i] = 1;
            }
        }
    }

    public static void segregatePartitionBased(int[] arr, int n) {
        partition(arr, 0, n - 1, n - 1);
    }

    public static int partition(int[] arr, int low, int high, int pivotIndex) {
        int pivotElement = arr[pivotIndex];
        // In lomuto's partition we always consider the last element as the
        // pivot element.
        if (pivotIndex != high)
            swap(arr, high, pivotElement);
        int i = low - 1;
        for (int j = low; j <= high - 1; j++) {
            if (arr[j] <= pivotElement) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    public static void swap(int arr[], int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
