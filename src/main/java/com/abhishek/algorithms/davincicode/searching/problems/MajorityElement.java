package com.abhishek.algorithms.davincicode.searching.problems;

public class MajorityElement {
    //Using Moore's voting algorithm
    public static int getMajorityElementIndex(int arr[], int n) {
        int result = 0;
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] == arr[result]) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                result = i;
                count = 1;
            }
        }
        count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[result] == arr[i])
                count++;
        }
        return (count > n / 2) ? result : -1;
    }
    public static void main(String args[]){
        int[] arr={8,8,6,6,6,4,6};
        int n=arr.length;
        int majorityElement=(getMajorityElementIndex(arr,n)!=-1)?arr[getMajorityElementIndex(arr,n)]:-1;
        System.out.println("Majority element "+majorityElement);
    }
}
