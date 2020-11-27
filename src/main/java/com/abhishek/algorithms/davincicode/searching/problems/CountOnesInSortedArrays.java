package com.abhishek.algorithms.davincicode.searching.problems;

public class CountOnesInSortedArrays {
    public static int getCountOfOnes(int[] arr,int low,int high){
        if(low>high)
            return 0;
        int mid=(low+high)/2;
        if(arr[mid]==1)
            return getCountOfOnes(arr,low,mid-1)+getCountOfOnes(arr,mid+1,high)+1;
        return getCountOfOnes(arr,mid+1,high);
    }
    public static void main(String args[]){
        int[] arr={0,0,0,0,1,1,1};
        int n=arr.length;
        System.out.println("The count: "+getCountOfOnes(arr,0,n-1));
    }
}
