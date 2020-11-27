package com.abhishek.algorithms.davincicode.hashing.problems;

public class LongestCommonSpanWithSameSumInTwoBinaryArrays {

    public static void main(String[] args) {
        int[] arr1 = {0, 1, 0, 1, 1, 1, 1};
        int[] arr2 = {1, 1, 1, 1, 1, 0, 1};
        int n = arr1.length;
        System.out.println("Find the longest common span with same sum in two binary arrays: "
                + getLongestCmnSpan(arr1, arr2, n));
        System.out.println("Find the longest common span with same sum in two binary arrays: "
                + getLongestCmnSpan2(arr1, arr2, n));
    }

    // Naive approach
    public static int getLongestCmnSpan(int[] arr1, int[] arr2, int n) {
        int[] prefixSum1 = new int[n];
        prefixSum1[0] = arr1[0];
        int[] prefixSum2 = new int[n];
        prefixSum2[0] = arr2[0];
        for (int i = 1; i < n; i++) {
            prefixSum1[i] = prefixSum1[i - 1] + arr1[i];
            prefixSum2[i] = prefixSum2[i - 1] + arr2[i];
        }
        return getLongestCmnSpan_aux(prefixSum1, prefixSum2, 0, n - 1);
    }

    private static int getLongestCmnSpan_aux(int[] prefixSum1, int[] prefixSum2, int start, int end) {
        if (end < start)
            return 0;
        int leftMove = getLongestCmnSpan_aux(prefixSum1, prefixSum2, start + 1, end);
        int rightMove = getLongestCmnSpan_aux(prefixSum1, prefixSum2, start, end - 1);
        int current_sum_1 = (start == end) ? prefixSum1[start]
                : start == 0 ? prefixSum1[end] : prefixSum1[end] - prefixSum1[start - 1];
        int current_sum_2 = (start == end) ? prefixSum2[start]
                : start == 0 ? prefixSum2[end] : prefixSum2[end] - prefixSum2[start - 1];
        int current = (current_sum_1 == current_sum_2) ? end - start + 1 : 0;
        return Math.max(current, Math.max(leftMove, rightMove));
    }

    public static int getLongestCmnSpan2(int[] arr1, int[] arr2, int n) {
        int[] arr3 = new int[n];
        for (int i = 0; i < n; i++)
            arr3[i] = arr1[i] - arr2[i];
        int result = LongestSubArrayWithGivenSum.getLongestSubarrayWithGivenSum(arr3, n, 0);
        return result;
    }


}
