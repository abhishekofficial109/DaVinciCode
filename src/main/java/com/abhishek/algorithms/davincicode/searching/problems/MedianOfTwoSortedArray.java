package com.abhishek.algorithms.davincicode.searching.problems;

public class MedianOfTwoSortedArray {

    public static void main(String args[]) {
        int[] A = {2, 3, 5, 8, 11, 18};
        int[] B = {10, 12, 14, 16};
        System.out.println("The median of two sorted array: " + getMedianOfTwoSorted(A, B, A.length, B.length));
    }

    public static float getMedianOfTwoSorted(int[] A, int[] B, int m, int n) {
        int size = m + n, median = (m + n) / 2, i = 0, j = 0, count = 0;
        if (size % 2 == 1) {
            while (i < m && j < n && count != median) {
                if (A[i] < B[j])
                    i++;
                else
                    j++;
                count++;
            }
            while (i < m && count != median) {
                i++;
                count++;
            }
            while (j < n && count != median) {
                j++;
                count++;
            }
            if (i == m)
                return B[j];
            else if (j == n)
                return A[i];
            else
                return Math.min(A[i], B[j]);
        } else {
            int previous = Integer.MIN_VALUE;
            while (i < m && j < n && count != median) {
                if (A[i] < B[j]) {
                    previous = A[i];
                    i++;
                } else {
                    previous = B[j];
                    j++;
                }
                count++;
            }
            while (i < m && count != median) {
                previous = A[i];
                i++;
                count++;
            }
            while (j < n && count != median) {
                previous = B[j];
                j++;
                count++;
            }
            if (i == m)
                return (float) ((B[j] + previous) / 2);
            else if (j == n)
                return (float) ((A[i] + previous) / 2);
            else
                return (float) (previous + Math.min(A[i], B[j])) / 2;
        }
    }
}
