package com.abhishek.algorithms.davincicode.hashing.problems;

import java.util.HashSet;
import java.util.Set;

public class SubArrayWithZeroSum {

  public static void main(String[] args) {
    int[] arr = {1, 4, 13, -3, -10, 5};
    int n = arr.length;
    System.out.println("Is subarray with zero sum: " + isSubArrayZeroSum(arr, n));
    System.out.println("Is subarray with zero sum: " + isSubArrayZeroSum2(arr, n));
  }

  public static boolean isSubArrayZeroSum(int[] arr, int n) {
    Set<Integer> set = new HashSet<>();
    int preFixSum = arr[0];
    set.add(preFixSum);
    for (int i = 1; i < n; i++) {
      preFixSum += arr[i];
      if (set.contains(preFixSum))
        return true;
      set.add(preFixSum);
    }
    return false;
  }

  public static boolean isSubArrayZeroSum2(int[] arr, int n) {
    return isSubArrayZeroSum2_aux(arr, 0, n - 1);
  }

  private static boolean isSubArrayZeroSum2_aux(int[] arr, int start, int end) {
    if (end < start)
      return false;
    boolean leftMove = isSubArrayZeroSum2_aux(arr, start + 1, end);
    boolean rightMove = isSubArrayZeroSum2_aux(arr, start, end - 1);
    int sum = 0;
    for (int i = start; i <= end; i++) {
      sum += arr[i];
    }
    return sum == 0 || leftMove || rightMove;
  }
}
