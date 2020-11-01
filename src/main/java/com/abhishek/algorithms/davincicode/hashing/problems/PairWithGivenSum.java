package com.abhishek.algorithms.davincicode.hashing.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PairWithGivenSum {

  public static void main(String[] args) {
    int[] arr = {11, 5, 6};
    int sum = 10;
    int n = arr.length;
    System.out.println("Is sum pair: " + isPair(arr, n, sum));
    System.out.println("Is sum pair: " + isPair1(arr, n, sum));
    System.out.println("Is sum pair: " + isPair2(arr, n, sum));
    System.out.println("Is sum pair: " + isPair3(arr, n, sum));
  }

  // Naive method
  public static boolean isPair(int[] arr, int n, int sum) {
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        if (i == j)
          continue;
        if (arr[i] + arr[j] == sum)
          return true;
      }
    }
    return false;
  }

  public static boolean isPair3(int[] arr, int n, int sum) {
    Set<Integer> set = new HashSet<Integer>();
    for (int i = 0; i < n; i++) {
      if (set.contains(sum - arr[i]))
        return true;
      set.add(arr[i]);
    }
    return false;
  }

  // Using hash map
  public static boolean isPair1(int[] arr, int n, int sum) {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i = 0; i < n; i++) {
      map.put(arr[i], i);
    }
    for (int i = 0; i < n; i++) {
      if (map.containsKey(sum - arr[i]) && map.get(sum - arr[i]) != i)
        return true;
    }
    return false;
  }

  // Using recursion
  public static boolean isPair2(int[] arr, int n, int sum) {
    if (n <= 0 || sum < 0)
      return false;
    else if (sum == 0)
      return true;
    boolean exclude = isPair2(arr, n - 1, sum);
    boolean include = isPair2(arr, n - 1, sum - arr[n - 1]);
    return exclude || include;
  }

}