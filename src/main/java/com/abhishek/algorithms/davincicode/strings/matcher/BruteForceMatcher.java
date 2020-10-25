package com.abhishek.algorithms.davincicode.strings.matcher;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BruteForceMatcher {

  public static List<Integer> matcher(String input, String pattern) {
    int n = input.length();
    int m = pattern.length();
    List<Integer> result = new LinkedList<>();
    for (int i = 0; i < n - m + 1; i++) {
      boolean isMatch = true;
      for (int j = 0; j < m; j++) {
        int xInput = input.charAt(i + j);
        int yInput = pattern.charAt(j);
        if (xInput != yInput) {
          isMatch = false;
          break;
        }
      }
      if (isMatch)
        result.add(i);
    }
    if (result.isEmpty())
      result.add(-1);
    return result;
  }

  // Based on Sliding window technique
  public static List<Integer> matcher_2(String input, String pattern) {
    int n = input.length(), patternSum = 0, inputSum = 0;
    int m = pattern.length();
    List<Integer> result = new LinkedList<>();
    Queue<Integer> queue = new LinkedList<Integer>();
    // Find the pattern sum
    for (int i = 0; i < m; i++)
      patternSum += pattern.charAt(i);

    // Find the sum input until first m characters
    for (int i = 0; i < m; i++) {
      inputSum += input.charAt(i);
      queue.offer((int) input.charAt(i));
    }
    if (inputSum == patternSum)
      result.add(0);
    // Match from 1 to n
    for (int i = 1; i < n - m + 1; i++) {
      inputSum -= queue.poll();
      int j = i + m - 1;
      inputSum += (int) input.charAt(j);
      queue.offer((int) input.charAt(j));
      if (inputSum == patternSum)
        result.add(i);
    }
    if (result.isEmpty())
      result.add(-1);
    return result;
  }

  // Based on the assumption that pattern has distinct characters
  // This will not work if the characters aren't unique.
  public static List<Integer> matcher_3(String txt, String pat) {
    int M = pat.length();
    int N = txt.length();
    int i = 0;
    List<Integer> result = new LinkedList<>();
    while (i <= N - M) {
      int j;

      /* For current index i, check for pattern match */
      for (j = 0; j < M; j++)
        if (txt.charAt(i + j) != pat.charAt(j))
          break;

      if (j == M) {
        result.add(i);
        i = i + M;
      } else if (j == 0)
        i = i + 1;
      else
        i = i + j; // slide the pattern by j
    }
    if (result.isEmpty())
      result.add(-1);
    return result;
  }

  public static void main(String[] args) {
    String input = "GEEKSFORGEEKS";
    System.out.println(matcher(input, "EKS"));
    System.out.println(matcher_2(input, "EKS"));
    System.out.println(matcher_3(input, "EKS"));
  }

}
