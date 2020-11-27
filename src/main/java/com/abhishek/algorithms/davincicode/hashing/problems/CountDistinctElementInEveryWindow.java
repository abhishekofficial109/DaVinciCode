package com.abhishek.algorithms.davincicode.hashing.problems;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CountDistinctElementInEveryWindow {

    public static void main(String[] args) {
        int[] arr = {10, 10, 10, 10};
        int n = arr.length;
        System.out.println(
                "Count distinct element in every window: " + countDistinctElementInEveryWindow(arr, n, 3));
    }

    public static List<Integer> countDistinctElementInEveryWindow(int[] arr, int n, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            if (map.containsKey(arr[i]))
                map.put(arr[i], map.get(arr[i]) + 1);
            else
                map.put(arr[i], 1);
        }
        result.add(map.size());
        int i = 0, j = k;
        while (j < n) {
            if (map.get(arr[i]) != null && map.get(arr[i]) > 1)
                map.put(arr[i], map.get(arr[i]) - 1);
            else
                map.remove(arr[i]);
            if (map.get(arr[j]) != null)
                map.put(arr[j], map.get(arr[j]) + 1);
            else
                map.put(arr[j], 1);
            result.add(map.size());
            j++;
            i++;
        }
        return result;
    }
}
