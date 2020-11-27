package com.abhishek.algorithms.davincicode.searching.problems;

public class FindPeakElementInAnUnsortedArray {
    public static void main(String args[]) {
        int[] arr = {5, 20, 40, 30, 20, 50, 60};
        System.out.println("Peak element: " + getPeakElement(arr, arr.length));
        System.out.println("Peak Element: " + getPeakElementBinarySearch(arr, 0, arr.length - 1));
    }

    //Naive approach
    public static int getPeakElement(int[] arr, int n) {
        if (n == 1)
            return arr[0];
        else if (arr[0] > arr[1])
            return arr[0];
        else if (arr[n - 1] > arr[n - 2])
            return arr[n - 1];
        int peakElement = Integer.MIN_VALUE;
        for (int i = 1; i < n - 2; i++) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                peakElement = arr[i];
                break;
            }
        }
        return peakElement;
    }

    //Efficient approach
    public static int getPeakElementBinarySearch(int[] arr, int low, int high) {
        int mid = (low + high) / 2;
        int n = arr.length;
        if (high==low)
            return arr[low];
        else if (mid - 1 < 0 && arr[mid] > arr[mid + 1]) {
            return arr[mid];
        } else if (mid + 1 == n && arr[mid] > arr[mid - 1]) {
            return arr[mid];
        } else if (arr[mid - 1] > arr[mid])
            return getPeakElementBinarySearch(arr, low, mid - 1);
        return getPeakElementBinarySearch(arr, mid + 1, high);
    }
}
