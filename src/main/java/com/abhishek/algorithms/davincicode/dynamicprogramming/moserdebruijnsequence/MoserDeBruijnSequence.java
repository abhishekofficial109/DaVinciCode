package com.abhishek.algorithms.davincicode.dynamicprogramming.moserdebruijnsequence;

import java.util.LinkedList;
import java.util.List;

public class MoserDeBruijnSequence {

    public static void main(String[] args) {
        int n = 10, i = 1, j = 0;
        List<Integer> list = new LinkedList<>();
        while (j < n) {
            if (isPowerOfFour(i)) {
                list.add(i);
                j++;
            }
            i++;
        }
        System.out.println(list);
    }

    private static boolean isPowerOfFour(int n) {
        return (n == 1) ? true : (n <= 0) ? false : isPowerOfFour(n / 4);
    }

}
