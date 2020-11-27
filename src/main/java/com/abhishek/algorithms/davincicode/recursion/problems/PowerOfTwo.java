package com.abhishek.algorithms.davincicode.recursion.problems;

public class PowerOfTwo {
    public static int printPowerOfTwo(int n){
        if(n==0)
            return 1;
        return printPowerOfTwo(n-1)+(int)Math.pow(2,n);
    }
    public static void main(String args[]){
        System.out.println("Power of two: "+PowerOfTwo.printPowerOfTwo(2));
    }
}
