package com.abhishek.algorithms.davincicode.hashing.problems;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MoreThanNByKOccurrence {

    public static void main(String[] args) {

    }

    public static List<Integer> getListOfElementsMoreThanNByK(int[] arr, int n, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int ratio = n / k;
        List<Integer> result = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(arr[i]))
                map.put(arr[i], map.get(arr[i]) + 1);
            else
                map.put(arr[i], 1);
        }
        for (Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > ratio)
                result.add(entry.getKey());
        }
        return result;
    }
}
