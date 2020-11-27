package com.abhishek.algorithms.davincicode.hashing.problems;

import java.util.*;

public class LongestConsecutiveSubsequence {

    public static void main(String[] args) {
        int[] arr = {1, 9, 3, 4, 2, 5};
        int n = arr.length;
        System.out.println(
                "Get the longest consecutive sequence: " + getTheLongestConsecutiveSequence_1(arr, n));
        System.out.println(
                "Get the longest consecutive sequence: " + getTheLongestConsecutiveSequence_2(arr, n));
        System.out.println(
                "Get the longest consecutive sequence: " + getTheLongestConsecutiveSequence(arr, n));
    }

    // Time complexity: n2
    public static int getTheLongestConsecutiveSequence(int[] arr, int n) {
        Arrays.sort(arr);
        return getTheLongestConsecutiveSequence_aux(arr, n - 1, new LinkedList<Integer>());
    }

    private static int getTheLongestConsecutiveSequence_aux(int[] arr, int n, List<Integer> list) {
        if (n < 0)
            return getTheLengthIfTheListIsConsecutive(list);
        List<Integer> temp = new LinkedList<>(list);
        temp.add(arr[n]);
        int exclude = getTheLongestConsecutiveSequence_aux(arr, n - 1, temp);
        int include = getTheLongestConsecutiveSequence_aux(arr, n - 1, list);
        return Math.max(include, exclude);
    }

    private static int getTheLengthIfTheListIsConsecutive(List<Integer> list) {
        if (list.isEmpty() || list.size() == 1)
            return list.size();
        int nextElement = list.get(0);
        for (Integer i : list) {
            if (i != nextElement)
                return 0;
            nextElement--;
        }
        return list.size();
    }

    // Another naive method
    public static int getTheLongestConsecutiveSequence_1(int[] arr, int n) {
        if (n == 0 || n == 1)
            return n;
        Arrays.sort(arr);
        int i = 0, j = 1, max = 1, current_max = 1;
        while (j < n) {
            if (arr[j] == arr[i] + 1) {
                i++;
                j++;
                current_max++;
                max = Math.max(max, current_max);
            } else {
                i = j;
                j++;
                current_max = 1;
            }
        }
        return max;
    }

    // Better method using Hashing
    public static int getTheLongestConsecutiveSequence_2(int[] arr, int n) {
        if (n == 0 || n == 1)
            return n;
        Set<Integer> set = new HashSet<>();
        int max = 1, current_max = 1;
        for (int i = 0; i < n; i++)
            set.add(arr[i]);
        for (int i = 1; i < n; i++) {
            if (set.contains(arr[i] - 1)) {
                current_max++;
                max = Math.max(current_max, max);
            } else {
                current_max = 1;
            }

        }
        return max;
    }

}
