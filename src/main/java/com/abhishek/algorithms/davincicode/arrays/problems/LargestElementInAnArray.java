package com.abhishek.algorithms.davincicode.arrays.problems;

public class LargestElementInAnArray {
    public static int maxElement(int[] arr) {
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(arr[i], max);
        }
        return max;
    }

    public static void main(String args[]) {
    }
}
