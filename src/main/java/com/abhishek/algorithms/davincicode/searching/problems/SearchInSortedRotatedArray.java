package com.abhishek.algorithms.davincicode.searching.problems;

public class SearchInSortedRotatedArray<T> {
    public static <T> int searchInSortedRotatedArray(T[] arr, T key, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (key == arr[mid])
            return mid;
        else if (arr[mid].hashCode() > arr[low].hashCode() && key.hashCode() >= arr[low].hashCode() && key.hashCode() <= arr[mid - 1].hashCode())
            return searchInSortedRotatedArray(arr, key, low, mid - 1);
        return searchInSortedRotatedArray(arr, key, mid + 1, high);
    }

    public static void main(String args[]) {
        Integer[] arr = {40, 50, 60, 70, 80, 10, 20, 30};
        System.out.println("Search: " + searchInSortedRotatedArray(arr, 20, 0, arr.length - 1));
    }
}
