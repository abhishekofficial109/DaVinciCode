package com.abhishek.algorithms.davincicode.sorting.intersection;

import java.util.ArrayList;

public class IntersectionPoint {

	public static void main(String[] args) {
		int[] arr1 = {1, 2, 2, 4, 6, 7};
		int[] arr2 = {2, 2, 2, 2, 2, 2, 3};
		System.out.println("Intersection point in two arrays: "
				+ intersection(arr1, arr1.length, arr2, arr2.length));
	}
	public static ArrayList<Integer> intersection(int[] arr1, int m, int[] arr2,
			int n) {
		ArrayList<Integer> result = new ArrayList<>();
		int i = 0, j = 0;
		while (i < m && j < n) {
			if (i > 0 && arr1[i] == arr1[i - 1])
				i++;
			else if (arr1[i] == arr2[j]) {
				result.add(arr1[i]);
				i++;
				j++;
			} else {
				if (arr1[i] < arr2[j])
					i++;
				else
					j++;
			}
		}
		return result;
	}

}
