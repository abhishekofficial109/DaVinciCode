package com.abhishek.algorithms.davincicode.searching.problems;

public class IndexOfFirstOccurence<T> {

    public static <T> int getTheIndexOfFirstOccurance(T[] arr, T key, int low, int high) {
        if (low > high)
            return Integer.MAX_VALUE;
        else if (low == high) {
            return (arr[low] == key) ? low : Integer.MAX_VALUE;
        }
        int mid = (low + high) / 2;
        if (arr[mid] == key) {
            return Math.min(mid, getTheIndexOfFirstOccurance(arr, key, low, mid));
        } else {
            return getTheIndexOfFirstOccurance(arr, key, mid + 1, high);
        }
    }

    public static void main(String args[]) {
        Integer[] arr = {1, 1, 1, 2, 2};
        System.out.println("Find me: " + getTheIndexOfFirstOccurance(arr, 2, 0, arr.length - 1));
    }
}
