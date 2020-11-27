package com.abhishek.algorithms.davincicode.arrays.problems;

import java.util.Arrays;

public class SecondLargestElement {
    public static void main(String args[]){}
    public static int secondMax(int[] arr){
        int firstLargest=LargestElementInAnArray.maxElement(arr);
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==firstLargest)
                continue;
            max=Math.max(max,arr[i]);
        }
        return max;
    }
    public static int secondLargest(int[] arr){
        int n=arr.length;
        Arrays.sort(arr);
        return arr[n-2];
    }
}
