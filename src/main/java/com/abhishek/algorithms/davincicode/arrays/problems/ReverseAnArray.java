package com.abhishek.algorithms.davincicode.arrays.problems;

public class ReverseAnArray<T> {
    public static <T> void reverse(T[] arr){
        int low=0,high=arr.length-1;
        while(low<high){
            T temp=arr[low];
            arr[low]=arr[high];
            arr[high]=temp;
            low++;
            high--;
        }
    }
}
