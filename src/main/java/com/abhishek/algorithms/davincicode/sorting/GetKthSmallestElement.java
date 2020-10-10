package com.abhishek.algorithms.davincicode.sorting;

import java.util.Arrays;

/**
 * @author abhishek Based on Lomuto's partition
 */
public class GetKthSmallestElement {

	public static void main(String[] args) {
		int[] arr = {24, 45, 23, 67, 10, 56};
		System.out.println("The Kth smallest element in an array: "
				+ getKthSmallestElement(arr, 2, 0, arr.length - 1));
		System.out.println(Arrays.toString(arr));
	}
	public static int getKthSmallestElement(int arr[], int K, int left,
			int right) {
		if (left > right)
			return -1;
		int pivot = partition(arr, left, right, right);
		if (arr[K - 1] == arr[pivot])
			return arr[pivot];
		else
			return (arr[K - 1] > arr[pivot])
					? getKthSmallestElement(arr, K, pivot + 1, right)
					: getKthSmallestElement(arr, K, left, pivot - 1);

	}
	/**
	 * 
	 * @param low:Should
	 *            always start from 0.
	 * @param high:
	 *            Should always start with the (size of the array-1)
	 * @param pivotIndex:
	 *            Index of the pivot element
	 * @return partition index
	 */
	public static int partition(int[] arr, int low, int high, int pivotIndex) {
		int pivotElement = arr[pivotIndex];
		// In lomuto's partition we always consider the last element as the
		// pivot element.
		if (pivotIndex != high)
			swap(arr, high, pivotElement);
		int i = low - 1;
		for (int j = low; j <= high - 1; j++) {
			if (arr[j] < pivotElement) {
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i + 1, high);
		return i + 1;
	}
	public static void swap(int arr[], int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

}
