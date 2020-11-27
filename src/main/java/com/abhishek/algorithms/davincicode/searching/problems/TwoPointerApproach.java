package com.abhishek.algorithms.davincicode.searching.problems;

public class TwoPointerApproach {
    //Given a sorted array, we have to find a pair whose sum is equal to the given sum.
    public static boolean getPairSum(int[] arr, int n, int sum) {
        int i = 0, j = n - 1;
        while (i < j) {
            int totalSum = arr[i] + arr[j];
            if (totalSum == sum)
                return true;
            else if (totalSum > sum)
                j--;
            else
                i++;
        }
        return false;
    }
    public static boolean getPairSum(int[] arr, int sum,int low,int high) {
        int i = low, j = high;
        while (i < j) {
            int totalSum = arr[i] + arr[j];
            if (totalSum == sum)
                return true;
            else if (totalSum > sum)
                j--;
            else
                i++;
        }
        return false;
    }

    //Given a sorted array we have to find a triplet if the sum of the triplet is equal to the given sum in the input.
    public static boolean getTripletSum(int[] arr, int n, int sum) {
        for(int i=0;i<n;i++){
            return getPairSum(arr,sum-arr[i],i+1,n-1);
        }
        return false;
    }
    public static void main(String args[]) {
        int[] arr = {3, 5, 9, 2, 8, 10, 11};
        int n = arr.length;
        System.out.println("Pair sum: " + getPairSum(arr, n, 17));
        System.out.println("Triplet sum: " + getTripletSum(arr, n, 45));
    }
}
