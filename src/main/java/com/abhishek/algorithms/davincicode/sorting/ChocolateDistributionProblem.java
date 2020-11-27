package com.abhishek.algorithms.davincicode.sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ChocolateDistributionProblem {

    public static void main(String[] args) {
        int[] arr = {7, 3, 2, 4, 9, 12, 56};
        int m = 3;
        int n = arr.length;
        System.out.println(
                "Minimum difference using brute force = : " + chocolateDistributionNaive(arr, n, m));
        System.out.println("Minimum difference using optimized approach = : "
                + chocolateDistributionGreedy(arr, n, m));
    }

    public static int chocolateDistributionNaive(int[] arr, int n, int m) {
        List<Integer> result = chocolateDistributionProblem_1(arr, new LinkedList<>(), n - 1, m);
        return ((result.size() == m) ? result.get(m - 1) - result.get(0) : (-1));
    }

    /**
     * Logic: Brute force approach The idea is to generate all the possible subsets and find the
     * minimum difference between the last element and the first element of an array.
     *
     * @param arr:        Input array
     * @param chocolates: The container to store the subsets
     * @param n:          input size of an array
     * @param m:          input size of the container
     * @return
     */
    public static List<Integer> chocolateDistributionProblem_1(int[] arr, List<Integer> chocolates,
                                                               int n, int m) {
        if (n < 0 || chocolates.size() == m)
            return chocolates;

        List<Integer> temp = new LinkedList<Integer>(chocolates);
        temp.add(arr[n]);
        List<Integer> include = chocolateDistributionProblem_1(arr, temp, n - 1, m);
        List<Integer> exclude = chocolateDistributionProblem_1(arr, chocolates, n - 1, m);
        int maxSize = Math.max(exclude.size(), include.size());
        if (maxSize != m)
            return exclude;
        else {
            if (exclude.size() == m && include.size() == m) {
                Collections.sort(exclude);
                int exMin = exclude.get(m - 1) - exclude.get(0);
                Collections.sort(include);
                int inMin = include.get(m - 1) - include.get(0);
                return (exMin < inMin) ? exclude : include;
            } else {
                return (exclude.size() == m) ? exclude : include;
            }
        }
    }

    // Better solution
    public static int chocolateDistributionGreedy(int[] arr, int n, int m) {
        if (n < m)
            return -1;
        Arrays.sort(arr);
        int min = arr[m - 1] - arr[0];
        int i = 1;
        for (int j = m; j < n; j++) {
            int diff = arr[j] - arr[i];
            min = Math.min(min, diff);
            i++;
        }
        return min;
    }
}
