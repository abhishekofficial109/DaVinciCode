package com.abhishek.algorithms.davincicode.sorting;

import java.util.Arrays;

/**
 * Based on Dutch national flag algorithm
 *
 * @author abhishek
 */
public class SegregateThreeTypesOfArrays {

    public static void main(String[] args) {
        int[] arr = {1, 1, 3, 2, 1, 3, 1, 2, 1, 3};
        segregate(arr, arr.length);
        System.out.println(Arrays.toString(arr));

    }

    /**
     * @param arr
     * @param n
     */
    public static void segregate(int[] arr, int n) {
        int low = 0, medium = 0, high = n - 1;
        while (medium <= high) {
            if (arr[medium] == 1) {
                swap(arr, low, medium);
                medium++;
                low++;
            } else if (arr[medium] == 2) {
                medium++;
            } else if (arr[medium] == 3) {
                swap(arr, medium, high);
                high--;
            }
        }
    }

    public static void swap(int arr[], int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
