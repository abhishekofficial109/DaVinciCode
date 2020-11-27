package com.abhishek.algorithms.davincicode.searching.problems;

import com.abhishek.algorithms.davincicode.util.Pair;

public class CountOnlyRepeated {
    public static void main(String args[]){
        Integer[] arr={1,1,1,2,3,4};
        System.out.println(findRepeating(arr,arr.length));
    }
    public static int find(int[] arr,int low,int high){
        if(low>high)
            return -1;
        int mid=(low+high)/2;
        int midValue=mid+1;
        if(arr[mid]==midValue)
            return find(arr,mid+1,high);
        else if(mid-1>=0 && (arr[mid-1]==arr[mid]||arr[mid+1]==arr[mid]))
            return arr[mid];
        return find(arr,low,mid-1);
    }
    public static int count(int[] arr,int low,int high,int key){
        if(low>high)
            return 0;
        int mid=(low+high)/2;
        if(arr[mid]==key) {
            int left=(mid-1>=0 && arr[mid-1]==key)?count(arr, low, mid - 1, key):0;
            int right=(mid+1<arr.length && arr[mid+1]==key)?count(arr, mid + 1, high, key):0;
            return 1 + left+right;
        }
        else if(key>arr[mid])
            return count(arr,mid+1,high,key);
        return count(arr,low,mid-1,key);
    }
    public static Pair<Integer,Integer> findRepeating(Integer arr[], int n)
    {
        int[] A=new int[n];
        for(int i=0;i<n;i++)
            A[i]=arr[i];
        int find=find(A,0,n-1);
        if(find!=-1){
            int count=count(A,0,n-1,find);
            return new Pair<Integer,Integer>(find,count);
        }
        return null;
    }

}
