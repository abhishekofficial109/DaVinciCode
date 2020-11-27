package com.abhishek.algorithms.davincicode.searching.problems;

public class CountOccurrenceInSortedArray {
    public static int getCount(int[] arr,int key,int low,int high){
        if(low>high){return 0;}
        int mid=(low+high)/2;
        if(arr[mid]==key)
            return getCount(arr,key,low,mid-1)+getCount(arr,key,mid+1,high)+1;
        else if(key>arr[mid])
            return getCount(arr,key,mid+1,high);
        return getCount(arr,key,low,mid-1);
    }
    public static void main(String args[]){
        int[] arr={10,20,20,20,30,30};
        System.out.println("The count: "+getCount(arr,5,0,arr.length-1));
    }
}
