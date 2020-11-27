package com.abhishek.algorithms.davincicode.sorting.countinversioninarray;

public class CountInversionInAnArray {

    public static void main(String[] args) {
        int arr[] = {2, 4, 1, 3, 5};
        System.out
                .print("Total number of inversion required: " + inversionInAnArray(arr, 0, arr.length - 1));
    }

    public static int inversionInAnArray(int arr[], int left, int right) {
        if (right - left <= 0)
            return 0;
        int mid = (left + right) / 2;
        int firstHalf = inversionInAnArray(arr, left, mid);
        int secondHalf = inversionInAnArray(arr, mid + 1, right);
        return count(arr, left, mid, right) + firstHalf + secondHalf;
    }

    public static int count(int[] arr, int left, int mid, int right) {
        int i = left, j = mid + 1;
        int inversionCount = 0;
        while (j <= right) {
            if (arr[i] > arr[j])
                inversionCount++;
            i++;
            if (i > mid) {
                i = left;
                j++;
            }
        }
        return inversionCount;

    }

}
