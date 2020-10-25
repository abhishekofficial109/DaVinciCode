package com.abhishek.algorithms.davincicode.sorting.partition;

/**
 * @author abhishek
 *
 */
public class LomutoPartition {

  public static void main(String[] args) {
    int[] arr = {71, 23, 24, 89, 56, 65, 34};
    System.out.println("Before Partitioning: ");
    print(arr, arr.length);
    lomutosPartition(arr, arr.length);
    System.out.println("\nAfter Partitioning: ");
    print(arr, arr.length);
  }

  public static int lomutosPartition(int[] arr, int N) {
    return partition(arr, 0, N - 1, N - 1);
  }

  /**
   * 
   * @param low:Should always start from 0.
   * @param high: Should always start with the (size of the array-1)
   * @param pivotIndex: Index of the pivot element
   * @return
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

  public static void print(int arr[], int N) {
    for (int i = 0; i < N; i++)
      System.out.print(arr[i] + " , ");
  }

}
