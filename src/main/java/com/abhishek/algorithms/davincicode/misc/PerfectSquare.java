package com.abhishek.algorithms.davincicode.misc;

public class PerfectSquare {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(nearestSqrt(100));
    }

    public static int nearestSqrt(int num) {
        if (num == 1)
            return 0;

        int sqrt = (int) Math.sqrt(num);
        if ((int) Math.pow(sqrt, 2) == num) {
            int x = num - (int) Math.pow(sqrt - 1, 2);
            int y = (int) Math.pow((sqrt + 1), 2) - num;
            if (x < y) {
                return (int) Math.pow(sqrt - 1, 2);
            } else {
                return (int) Math.pow((sqrt + 1), 2);
            }
        } else {
            int a = num - (int) Math.pow(sqrt, 2);
            int b = (int) Math.pow((sqrt + 1), 2) - num;
            if (a == b)
                return (int) Math.pow((sqrt + 1), 2);
            else if (a < b)
                return (int) Math.pow(sqrt, 2);
            else
                return (int) Math.pow((sqrt + 1), 2);
        }
    }

}
