package com.abhishek.algorithms.davincicode.sorting.bucketsort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BucketSort {

  public static void main(String[] args) {
    float arr[] = {(float) 0.897, (float) 0.565, (float) 0.656, (float) 0.1234, (float) 0.665,
        (float) 0.3434};

    int n = arr.length;
    bucketSort(arr, n);
    System.out.print(Arrays.toString(arr));
  }

  public static void bucketSort(int n[], int k) {
    int N = n.length;
    int maxVal = n[0];
    for (int i = 1; i < N; i++) {
      maxVal = Math.max(n[i], maxVal);
    }
    maxVal++;

    ArrayList<ArrayList<Integer>> buckets = new ArrayList<>();
    for (int i = 0; i < k; i++) {
      buckets.add(new ArrayList<Integer>());
    }

    for (int i = 0; i < N; i++) {
      int bucketId = (k * n[i]) / maxVal;
      buckets.get(bucketId).add(n[i]);
    }
    for (int i = 0; i < k; i++) {
      Collections.sort(buckets.get(i));
    }

    ArrayList<Integer> mergedList = new ArrayList<>();
    for (int i = 0; i < k; i++) {
      mergedList.addAll(buckets.get(i));
    }
    for (int i = 0; i < N; i++) {
      n[i] = mergedList.get(i);
    }
  }

  public static void bucketSort(float n[], int k) {
    int N = n.length;
    float maxVal = n[0];
    for (int i = 1; i < N; i++) {
      maxVal = Math.max(n[i], maxVal);
    }
    maxVal++;

    ArrayList<ArrayList<Float>> buckets = new ArrayList<>();
    for (int i = 0; i < k; i++) {
      buckets.add(new ArrayList<Float>());
    }

    for (int i = 0; i < N; i++) {
      int bucketId = (int) ((k * n[i]) / maxVal);
      buckets.get(bucketId).add(n[i]);
    }
    for (int i = 0; i < k; i++) {
      Collections.sort(buckets.get(i));
    }

    ArrayList<Float> mergedList = new ArrayList<>();
    for (int i = 0; i < k; i++) {
      mergedList.addAll(buckets.get(i));
    }
    for (int i = 0; i < N; i++) {
      n[i] = mergedList.get(i);
    }
  }

}
