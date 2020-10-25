package com.abhishek.algorithms.davincicode.sorting.mergesort;

public class MergeSort {
  public static void main(String[] args) {
    int[] arr = {7, 1, 11, 55, 2, 4, 6};
    int n = arr.length;
    System.out.println("Before sorting: ");
    printArray(arr, n);
    sort(arr, n);
    System.out.println("\nAfter sorting: ");
    printArray(arr, n);
  }

  public static void sort(int[] arr, int n) {
    mergeSort(arr, 0, n - 1);
  }

  public static void mergeSort(int[] arr, int startIndex, int endIndex) {
    if (startIndex >= endIndex)
      return;
    int mid = (startIndex + endIndex) / 2;
    mergeSort(arr, startIndex, mid);
    mergeSort(arr, mid + 1, endIndex);
    merge(arr, startIndex, mid, endIndex);
  }

  public static void merge(int[] arr, int startIndex, int midIndex, int endIndex) {
    int N = ((endIndex + 1) - startIndex);
    int counter = 0;
    int[] tempArr = new int[N];
    int i = startIndex, j = midIndex + 1;
    while (i <= midIndex && j <= endIndex) {
      if (arr[i] > arr[j]) {
        tempArr[counter] = arr[j];
        j++;
      } else {
        tempArr[counter] = arr[i];
        i++;
      }
      counter++;
    }
    while (i <= midIndex) {
      tempArr[counter] = arr[i];
      i++;
      counter++;
    }
    while (j <= endIndex) {
      tempArr[counter] = arr[j];
      j++;
      counter++;
    }
    counter = 0;
    for (int l = startIndex; l <= endIndex; l++) {
      arr[l] = tempArr[counter];
      counter++;
    }
  }

  public static void printArray(int[] arr, int n) {
    for (int i = 0; i < n; i++)
      System.out.print(arr[i] + " , ");
  }
}
