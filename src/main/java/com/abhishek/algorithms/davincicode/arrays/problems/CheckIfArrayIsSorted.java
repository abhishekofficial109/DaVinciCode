package com.abhishek.algorithms.davincicode.arrays.problems;

public class CheckIfArrayIsSorted {
    public static boolean isSorted(int[] arr,int n){
        for(int i=0;i<n;i++){
            for(int j=i+1;i<n;i++){
                if(arr[j]<arr[i])
                    return false;
            }
        }
        return true;
    }
    public static boolean isSorted(int[] arr){
        for(int i=1;i<arr.length;i++){
            if(arr[i]<arr[i-1])
                return false;
        }
        return true;
    }
}
