package com.abhishek.algorithms.davincicode.sorting.radixsort;

import java.util.Arrays;

/**
 * Radix sort is based on the sorting of the digits Please go through the geeksforgeeks article for
 * further details https://www.geeksforgeeks.org/radix-sort/
 *
 * @author abhishek
 */
public class RadixSort {

    public static void main(String[] args) {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        radixSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    public static void radixSort(int[] arr, int n) {
        // Step-1: To find out the maximum element in the array
        int max = findMax(arr, n);
        // Step-2: To find out the total number of digits in the maximum value
        int totalNumberOfDigits = totalDigitsInANumber(max);
        // Step-3: To sort the array based its digits
        for (int i = 1; i <= totalNumberOfDigits; i++)
            countingSortBasedOnDigitsPlace(arr, n, i);
    }

    private static void countingSortBasedOnDigitsPlace(int[] arr, int n, int place) {
        int[] output = new int[n];
        // There can be only 10 digits 0-9
        int[] count = new int[10];
        for (int i = 0; i < n; i++) {
            int digit = getDigitByItsPlace(arr[i], place, 1);
            count[digit] += 1;
        }
        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        for (int i = n - 1; i >= 0; i--) {
            int value = arr[i];
            int digit = getDigitByItsPlace(value, place, 1);
            output[count[digit] - 1] = value;
            count[digit]--;
        }
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    private static int findMax(int[] arr, int n) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++)
            max = Math.max(arr[i], max);
        return max;
    }

    private static int totalDigitsInANumber(int n) {
        if (n <= 0)
            return 0;
        return 1 + totalDigitsInANumber(n / 10);
    }

    private static int getDigitByItsPlace(int n, int place, int index) {
        if (n <= 0)
            return 0;
        if (index == place)
            return n % 10;
        return getDigitByItsPlace(n / 10, place, index + 1);
    }

}
