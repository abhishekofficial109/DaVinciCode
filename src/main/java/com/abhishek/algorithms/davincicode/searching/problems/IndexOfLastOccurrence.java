package com.abhishek.algorithms.davincicode.searching.problems;

public class IndexOfLastOccurrence {
    public static <T> int getTheIndexOfLastOccurrence(T[] arr, T key, int low, int high) {
        if (low > high)
            return -1;
        int mid = (low + high) / 2;
        if (arr[mid] == key) {
            return Math.max(mid, getTheIndexOfLastOccurrence(arr, key, mid + 1, high));
        } else if (key.hashCode() > arr[mid].hashCode()) {
            return getTheIndexOfLastOccurrence(arr, key, mid + 1, high);
        } else {
            return getTheIndexOfLastOccurrence(arr, key, low, mid - 1);
        }
    }

    public static void main(String args[]) {
        Integer[] arr = {1, 2, 3, 5, 6};
        System.out.println("Find me: " + getTheIndexOfLastOccurrence(arr, 5, 0, arr.length - 1));
    }
}
