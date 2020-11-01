package com.abhishek.algorithms.davincicode.arrays.problem;

public class PrintAllSubarrays {

  private static int[][] dp;

  public static void main(String[] args) {
    int[] arr = {1, 2, 3};
    int n = arr.length;
    dp = new int[n + 1][n + 1];
    printAllSubArrays(arr, 0, n - 1);
  }

  public static void printAllSubArrays(int[] arr, int start, int end) {
    // matrix is used to avoid overlapping sub problems
    if (end < start || dp[start][end] == 1)
      return;
    printAllSubArrays(arr, start + 1, end);
    printAllSubArrays(arr, start, end - 1);
    for (int i = start; i <= end; i++) {
      System.out.print(arr[i] + ",");
    }
    dp[start][end] = 1;
    System.out.println();
  }
}
