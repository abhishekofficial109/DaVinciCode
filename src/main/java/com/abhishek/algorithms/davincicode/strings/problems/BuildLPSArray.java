package com.abhishek.algorithms.davincicode.strings.problems;

import java.util.Arrays;

public class BuildLPSArray {


    public static void main(String[] args) {
        String s = "AAABAAA";
        int M = s.length();
        System.out.println(Arrays.toString(buildLpsArray(s)));
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


}
