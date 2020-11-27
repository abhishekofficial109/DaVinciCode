package com.abhishek.algorithms.davincicode.searching.problems;

public class SquareRoot {
    public static long sqrt(long n) {
        if (n == 0 || n == 1)
            return n;
        return sqrtOfValue(n, 2, n);
    }

    private static long sqrtOfValue(long value, long low, long high) {
        if (low >= high)
            return -1;
        long mid = (low + high) / 2;
        if (Math.pow(mid, 2) == value)
            return mid;
        else if (Math.pow(mid, 2) < value)
            return Math.max(mid, sqrtOfValue(value, mid + 1, high));
        return sqrtOfValue(value, low, mid);
    }


    public static void main(String args[]) {
        System.out.println("Square root of number: " + sqrt(19));
    }
}
