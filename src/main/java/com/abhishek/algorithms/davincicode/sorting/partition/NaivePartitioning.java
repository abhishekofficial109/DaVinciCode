package com.abhishek.algorithms.davincicode.sorting.partition;

public class NaivePartitioning {

  public static void main(String[] args) {
    int[] arr = {71, 23, 24, 89, 34, 65, 56};
    System.out.println("Before Partitioning: ");
    print(arr, arr.length);
    arr = partition(arr, 34);
    System.out.println("\nAfter Partitioning: ");
    print(arr, arr.length);
  }

  public static int[] partition(int[] arr, int pivot) {
    int N = arr.length;
    int counter = 0;
    int[] temp = new int[N];
    int[] greaterArray = new int[N];
    int gc = 0;
    for (int i = 0; i < N; i++) {
      if (arr[i] <= pivot)
        temp[counter++] = arr[i];
      else
        greaterArray[gc++] = arr[i];
    }

    for (int i = 0; i < gc; i++)
      temp[counter++] = greaterArray[i];
    return temp;
  }

  public static void print(int arr[], int N) {
    for (int i = 0; i < N; i++)
      System.out.print(arr[i] + " , ");
  }

}
