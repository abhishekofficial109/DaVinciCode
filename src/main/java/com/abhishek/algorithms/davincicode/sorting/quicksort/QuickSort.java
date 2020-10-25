package com.abhishek.algorithms.davincicode.sorting.quicksort;

import java.util.Arrays;

public class QuickSort {

  public static void main(String[] args) {
    int[] arr = {24, 45, 23, 10, 67, 56};
    System.out.println("Before Sort: " + Arrays.toString(arr));
    qSort(arr, 0, arr.length - 1);
    System.out.println("After Sort: " + Arrays.toString(arr));
  }

  public static void qSort(int[] arr, int left, int right) {
    if (left > right)
      return;
    int pivot = partition(arr, left, right, right);
    qSort(arr, left, pivot - 1);
    qSort(arr, pivot + 1, right);
  }

  // Based on Lomuto's partition
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
