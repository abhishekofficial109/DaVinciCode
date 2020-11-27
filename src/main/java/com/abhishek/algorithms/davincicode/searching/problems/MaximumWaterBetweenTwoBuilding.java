package com.abhishek.algorithms.davincicode.searching.problems;

public class MaximumWaterBetweenTwoBuilding {
    public static void main(String args[]) {
        int[] arr = {2, 1, 3, 4, 6, 5};
        int n = arr.length;
        System.out.println("Max water: " + maxWater(arr, n));
    }

    public static int maxWater(int[] arr, int n) {
        int result = Integer.MIN_VALUE, i = 0, j = n - 1;
        while (i < j) {
            int diff = (j - i - 1) <= 1 ? 0 : j - i - 1;
            result = Math.max(result, Math.min(arr[i], arr[j]) * diff);
            if (arr[i] < arr[j])
                i++;
            else
                j--;
        }
        return result;
    }
}
