package com.abhishek.algorithms.davincicode.strings.matcher;

import java.util.LinkedList;
import java.util.List;

public class RabinKarpAlgorithm {

  private static int d = 256;
  private static int q = 101;
  private int m;
  private int n;

  public static void main(String[] args) {
    RabinKarpAlgorithm matcher = new RabinKarpAlgorithm();
    System.out.println(matcher.matcher("GEEKSFORGEEKS", "EKS"));
  }

  public List<Integer> matcher(String input, String pattern) {
    List<Integer> result = new LinkedList<Integer>();
    m = pattern.length();
    n = input.length();
    int h = 1;// h= d^m-1
    int p = 0;// hash value of pattern
    int t = 0;// hash value of text
    // calculate h= d^m-1
    for (int i = 1; i <= m - 1; i++)
      h = (h * d) % q;

    // Calculate the hash of pattern and the first window of input;
    for (int i = 0; i < m; i++) {
      p = (p * d + pattern.charAt(i)) % q;
      t = (t * d + input.charAt(i)) % q;
    }


    for (int i = 0; i <= n - m; i++) {
      if (p == t) {
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
      if (i < n - m) {
        t = (d * (t - input.charAt(i) * h) + input.charAt(i + m)) % q;
        // We might get negative value of t, converting it
        // to positive
        if (t < 0)
          t = (t + q);
      }
    }
    if (result.isEmpty())
      result.add(-1);
    return result;
  }


}
