package com.abhishek.algorithms.davincicode.sorting.union;

import java.util.ArrayList;

public class UnionOfTwoArrays {

    public static void main(String[] args) {
        int[] arr1 = {19, 24, 27, 38, 39};
        int[] arr2 = {5, 7, 9, 16, 21, 22, 23, 24, 25, 28, 28, 30, 30, 31, 33, 34, 37, 40, 42, 46};
        System.out.println("Union of two arrays: " + union(arr1, arr1.length, arr2, arr2.length));
    }

    public static ArrayList<Integer> union(int[] arr1, int m, int[] arr2, int n) {
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (i > 0 && arr1[i] == arr1[i - 1]) {
                i++;
                continue;
            }
            if (j > 0 && arr2[j] == arr2[j - 1]) {
                j++;
                continue;
            } else if (arr1[i] == arr2[j]) {
                result.add(arr1[i]);
                i++;
                j++;
            } else {
                if (arr1[i] < arr2[j]) {
                    result.add(arr1[i]);
                    i++;
                } else {
                    result.add(arr2[j]);
                    j++;
                }
            }
        }
        while (i < m) {
            if (i > 0 && arr1[i] == arr1[i - 1]) {
                i++;
                continue;
            }
            result.add(arr1[i]);
            i++;
        }
        while (j < n) {
            if (j > 0 && arr2[j] == arr2[j - 1]) {
                j++;
                continue;
            }
            result.add(arr2[j]);
            j++;
        }
        return result;
    }

}
