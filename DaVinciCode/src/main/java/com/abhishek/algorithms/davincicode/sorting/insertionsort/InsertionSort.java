package com.abhishek.algorithms.davincicode.sorting.insertionsort;

public class InsertionSort {

	public static void main(String[] args) {
		int[] arr= {7,1,11,55,2,4,6};
		int n=arr.length;
		System.out.println("Before sorting: ");
		printArray(arr, n);
		sort(arr,n);
		System.out.println("\nAfter sorting: ");
		printArray(arr, n);
	}
	public static void sort(int[] arr, int n) {
		if (n == 1)
			return;
		sort(arr, n - 1);
		for (int i = n - 1; i > 0; i--) {
			if (arr[i - 1] > arr[i]) {
				int temp = arr[i];
				arr[i] = arr[i - 1];
				arr[i - 1] = temp;
			}
		}
	}
	public static void printArray(int[] arr, int n) {
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " , ");
	}

}
