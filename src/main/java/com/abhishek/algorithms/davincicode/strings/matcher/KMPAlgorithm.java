package com.abhishek.algorithms.davincicode.strings.matcher;

import java.util.LinkedList;
import java.util.List;

public class KMPAlgorithm {

  public static void main(String[] args) {
    
  }

  public static int[] buildLpsArray(String pattern) {
    int M = pattern.length();// The length of the pattern
    int[] lps = new int[M];
    int i = 1;// Iterator cursor
    int len = 0;// Initial length of the LPS i-1
    lps[0] = 0;// The first LPS of the array is always zero
    while (i < M) {
      // Case-1
      // When the LPS at i-1 is equal to i
      if (pattern.charAt(len) == pattern.charAt(i)) {
        len++;
        lps[i] = len;
        i++;
      } else {
        // If none of the characters have matched so far then the current LPS at position i will
        // also be zero
        if (len == 0) {
          lps[i] = 0;
          i++;
        } else {
          // If LPS before was not zero then move the LPS i-1 culture back until we find a match. if
          // the match
          while (len != 0 && pattern.charAt(len) != pattern.charAt(i))
            len--;
          if (pattern.charAt(len) == pattern.charAt(i))
            len++;
          lps[i] = len;
          i++;
        }
      }
    }
    return lps;
  }

  public static List<Integer> matcher(String input, String pattern) {
    List<Integer> result = new LinkedList<Integer>();
    int[] lps = buildLpsArray(pattern);
    int i = 0, j = 0, n = input.length(), m = pattern.length();
    while (i < n) {
      if (input.charAt(i) == pattern.charAt(j)) {
        i++;
        j++;
      }
      if (j == m) {
        result.add(i - j);
        j = lps[j - 1];
      } else if (i < n && input.charAt(i) != pattern.charAt(j)) {
        if (j == 0) {
          i++;
        } else {
          i++;
          j = lps[j - 1];
        }
      }
    }
    if (result.isEmpty())
      result.add(-1);
    return result;
  }
}
