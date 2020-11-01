package com.abhishek.algorithms.davincicode.strings.problems;

// To check if two Strings can be formed by rotating it.
public class StringRotation {

  public static void main(String[] args) {
    String s1 = "ABCD";
    String s2 = "CDAB";
    System.out.println(isStringRotation(s1, s2, 0));
    System.out.println(isStringRotation(s1, s2));
  }

  public static boolean isStringRotation(String s1, String s2, int n) {
    if (n == s1.length())
      return false;
    else if (s1.equals(s2))
      return true;
    char c = s1.charAt(0);
    s1 = s1.substring(1, s1.length());
    s1 += c;
    return isStringRotation(s1, s2, n + 1);
  }

  public static boolean isStringRotation(String s1, String s2) {
    s1 += s1;
    return s1.contains(s2);
  }

}
