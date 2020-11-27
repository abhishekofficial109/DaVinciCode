package com.abhishek.algorithms.davincicode.searching.problems;

public class RepeatingElement {
    public static int getRepeatingElement(int[] arr) {
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++)
            max = Math.max(max, arr[i]);
        int[] countArr = new int[max + 1];
        for (int i = 0; i < n; i++) {
            int index = arr[i];
            if (countArr[index] == 0)
                countArr[index] = 1;
            else
                return index;
        }
        return -1;
    }

    //Efficient Algorithm
    public static int getRepeatingElements_2(int[] arr){
        int slow=arr[0]+1;
        int fast=arr[0]+1;
        do {
            slow=arr[slow]+1;
            fast=arr[arr[fast]+1]+1;
        }while(slow!=fast);
        slow=arr[0]+1;
        while(slow!=fast){
            slow=arr[slow]+1;
            fast=arr[fast]+1;
        }
        return slow-1;
    }

    public static void main(String args[]) {
        int[] arr={0,2,1,3,2,2};
        System.out.println("Repeating elements: "+getRepeatingElement(arr));
        System.out.println("Repeating elements: "+getRepeatingElements_2(arr));

    }
}
