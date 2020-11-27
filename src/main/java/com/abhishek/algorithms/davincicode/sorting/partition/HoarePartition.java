package com.abhishek.algorithms.davincicode.sorting.partition;

public class HoarePartition {

    public static void main(String[] args) {
        int[] arr = {56, 23, 24, 89, 71, 65, 34};
        System.out.println("Before Partitioning: ");
        print(arr, arr.length);
        int partion = hoarePartition(arr, arr.length);
        System.out.println("\nAfter Partitioning: Partion index=" + partion);
        print(arr, arr.length);
    }

    public static int hoarePartition(int[] arr, int N) {
        return partition(arr, 0, N - 1);
    }

    /**
     * @param low:Should always start from 0.
     * @param high:      Should always start with the (size of the array-1)
     * @return
     */
    public static int partition(int[] arr, int low, int high) {
        int i = low - 1, j = high + 1;
        // In Hoare's partition the first element is always considered as pivot
        int pivot = arr[low];
        while (true) {
            do {
                i++;
            } while (arr[i] < pivot);
            do {
                j--;
            } while (arr[j] > pivot);
            if (i >= j)
                return j;
            swap(arr, i, j);
        }
    }

    public static void swap(int arr[], int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void print(int arr[], int N) {
        for (int i = 0; i < N; i++)
            System.out.print(arr[i] + " , ");
    }
}
