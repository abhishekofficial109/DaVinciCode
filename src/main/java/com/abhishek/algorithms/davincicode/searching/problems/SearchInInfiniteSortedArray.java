package com.abhishek.algorithms.davincicode.searching.problems;

import com.abhishek.algorithms.davincicode.searching.BinarySearch;

public class SearchInInfiniteSortedArray {
    public static int getUpperBound(Integer[] arr,Integer key,int high){
        while(arr[high]<key){
            high*=2;
        }
        return high;
    }
    private static boolean search(Integer[] arr, int low, int high, Integer key) {
        if (low > high)
            return false;
        int mid = (low + high) / 2;
        if (arr[mid] == key)
            return true;
        else {
            if (key > arr[mid])
                return search(arr, mid + 1, high, key);
            else
                return search(arr, low, mid-1, key);
        }
    }
    public static void main(String args[]){
        Integer[] arr=new Integer[1000000];
        for(int i=1;i<999999;i++){
            arr[i-1]=i;
        }
        arr[13]=13;
        System.out.println(search(arr,0,getUpperBound(arr,14,1),14));
    }
}
