package com.abhishek.algorithms.davincicode.dynamicprogramming.newmanconwaysequence;

/*
 * Source: https://www.geeksforgeeks.org/newman-conway-sequence/
 *
 */

public class NewmanConwaySequence {

    public static void main(String[] args) {
        System.out.println("Newman Conway sequence: " + newManConwaySequence(10));
        System.out.println("Newman Conway sequence: " + funDp(10));
    }

    private static int newManConwaySequence(int n) {
        if (n == 1 || n == 2)
            return 1;
        if (n == 0)
            return 0;
        return newManConwaySequence(newManConwaySequence(n - 1))
                + newManConwaySequence(n - newManConwaySequence(n - 1));
    }

    private static int funDp(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i < n + 1; i++)
            dp[i] = dp[dp[i - 1]] + dp[i - dp[i - 1]];
        return dp[n];
    }

}
