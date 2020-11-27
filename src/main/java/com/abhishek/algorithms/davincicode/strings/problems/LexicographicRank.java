package com.abhishek.algorithms.davincicode.strings.problems;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class LexicographicRank {

    public static void main(String[] args) {
        String str = "STRING";
        System.out.println("Lexicographic Rank: " + lexicographicRank(str, str.length()));
        System.out.println("Lexicographic Rank: " + getLexicographicRank("baca"));
    }

    private static int getLexicographicRank(String txt) {
        char[] arr = txt.toCharArray();
        Arrays.sort(arr);
        String temp = String.valueOf(arr);
        Set<String> set = permuteString(temp, 0, temp.length() - 1, new LinkedHashSet<String>());
        int rank = 0;
        for (String str : set) {
            if (str.equals(txt)) {
                return ++rank;
            }
        }
        return rank;
    }


    private static LinkedHashSet<String> permuteString(String s, int l, int r,
                                                       LinkedHashSet<String> result) {
        if (l == r)
            result.add(s);

        for (int i = l; i <= r; i++) {
            s = swap(s, l, i);
            result = permuteString(s, l + 1, r, result);
        }
        return result;
    }

    private static String swap(String str, int newIndex, int oldIndex) {
        char[] arr = str.toCharArray();
        int val = arr[oldIndex];
        arr[oldIndex] = arr[newIndex];
        arr[newIndex] = (char) val;
        str = String.valueOf(arr);
        return str;
    }

    private static int lexicographicRank(String txt, int n) {
        int[] lowerIndex = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            int count = 0;
            for (int j = i + 1; j < n; j++) {
                if (txt.charAt(i) > txt.charAt(j)) {
                    count++;
                }
            }
            lowerIndex[i] = count;
        }
        int[] factTab = factorial(n);
        int j = 1;
        int result = 0;
        for (int i = 0; i < n; i++) {
            result = result + (lowerIndex[i] * factTab[n - j]);
            j++;
        }
        return ++result;
    }

    private static int[] factorial(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] * i;
        }
        return dp;
    }


}
