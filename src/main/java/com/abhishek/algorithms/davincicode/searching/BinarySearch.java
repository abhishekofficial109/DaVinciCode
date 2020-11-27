package com.abhishek.algorithms.davincicode.searching;

import java.util.Arrays;

public class BinarySearch<T> {
    private static <T> boolean search(T[] arr, int low, int high, T key) {
        if (low > high)
            return false;
        int mid = (low + high) / 2;
        if (arr[mid] == key)
            return true;
        else {
            if (key.hashCode() > arr[mid].hashCode())
                return search(arr, mid + 1, high, key);
            else
                return search(arr, low, mid-1, key);
        }
    }

    public static <T> boolean search(T[] arr, T key) {
        Arrays.sort(arr);
        return search(arr, 0, arr.length - 1, key);
    }

    public static <T> boolean find(T[] arr, T key) {
        Arrays.sort(arr);
        int n = arr.length;
        int low = 0, high = n - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] == key)
                return true;
            else if (key.hashCode() > arr[mid].hashCode())
                low = mid + 1;
            else
                high = mid;
        }
        return false;
    }

    public static void main(String args[]) {
        Integer[] arr = {3, 1, 2, 4, 6, 7};
        System.out.println("Find me: " + search(arr, 3));
        System.out.println("Find me: " + find(arr, 0));
    }
}
