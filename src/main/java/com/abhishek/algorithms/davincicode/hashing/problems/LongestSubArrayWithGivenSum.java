package com.abhishek.algorithms.davincicode.hashing.problems;

import java.util.HashMap;

public class LongestSubArrayWithGivenSum {

    public static void main(String[] args) {
        int[] arr = {3, 1, 0, 1, 8, 2, 3, 6};
        int n = arr.length;
        int sum = 5;
        System.out.println(
                "The longest sub-array with given sum: " + getLongestSubarrayWithGivenSum(arr, n, sum));
        System.out.println(
                "The longest sub-array with given sum: " + getLongestSubArrayWithGivenSum_2(arr, n, sum));
    }

    // Naive method
    public static int getLongestSubarrayWithGivenSum(int[] arr, int n, int sum) {
        int[] prefixSum = new int[n];
        prefixSum[0] = arr[0];
        for (int i = 1; i < n; i++)
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        return getLongestSubarrayWithGivenSum_aux(prefixSum, 0, n - 1, sum);
    }

    private static int getLongestSubarrayWithGivenSum_aux(int[] prefixSum, int start, int end,
                                                          int sum) {
        if (end < start)
            return 0;
        int leftMove = getLongestSubarrayWithGivenSum_aux(prefixSum, start + 1, end, sum);
        int rightMove = getLongestSubarrayWithGivenSum_aux(prefixSum, start, end - 1, sum);
        int current_sum = (start == end) ? prefixSum[start]
                : start == 0 ? prefixSum[end] : prefixSum[end] - prefixSum[start - 1];
        int current = (current_sum == sum) ? end - start + 1 : 0;
        return Math.max(current, Math.max(leftMove, rightMove));
    }

    // Better solution
    // Using hashing and prefix sum
    public static int getLongestSubArrayWithGivenSum_2(int arr[], int n, int sum) {
        int[] prefixSum = new int[n];
        prefixSum[0] = arr[0];
        for (int i = 1; i < n; i++)
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        int longest = Integer.MIN_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(prefixSum[0], 0);
        for (int i = 1; i < n; i++) {
            if (prefixSum[i] == sum)
                longest = Math.max(longest, i + 1);
            else if (map.containsKey(Math.abs(sum - prefixSum[i])))
                longest = Math.max(longest, i - map.get(Math.abs(sum - prefixSum[i])));
            if (!map.containsKey(prefixSum[i]))
                map.put(prefixSum[i], i);
        }
        return longest;
    }

}
