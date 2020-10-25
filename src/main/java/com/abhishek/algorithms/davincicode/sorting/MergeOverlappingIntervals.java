package com.abhishek.algorithms.davincicode.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import com.abhishek.algorithms.davincicode.util.Pair;

/**
 * 
 * O(nlogn): Time complexity O(1) extra space
 * 
 * Logic: 1. Sort the list in the increasing order of its begin time 2. Iterate and check
 * 
 * @author abhishek
 *
 */
public class MergeOverlappingIntervals {

  public static void main(String[] args) {
    List<Pair<Integer, Integer>> list = new LinkedList<>();
    list.add(new Pair<Integer, Integer>(1, 3));
    list.add(new Pair<Integer, Integer>(2, 6));
    list.add(new Pair<Integer, Integer>(8, 10));
    list.add(new Pair<Integer, Integer>(15, 18));
    Collections.sort(list, new IntervalComparator());
    System.out.println(mergeOverlappingIntervals(list, list.size()));

  }

  public static ArrayList<Pair<Integer, Integer>> mergeOverlappingIntervals(
      List<Pair<Integer, Integer>> list, int n) {
    Pair<Integer, Integer> currentPair = list.get(0);
    Pair<Integer, Integer> recentlyAdded = list.get(0);

    ArrayList<Pair<Integer, Integer>> result = new ArrayList<>();
    for (int i = 1; i < n; i++) {
      Pair<Integer, Integer> p = list.get(i);
      if (p.getKey() <= currentPair.getValue()) {
        Integer newStart = Math.min(p.getKey(), currentPair.getKey());
        Integer newEnd = Math.max(p.getValue(), currentPair.getValue());
        currentPair = new Pair<Integer, Integer>(newStart, newEnd);

      } else {
        result.add(currentPair);
        recentlyAdded = currentPair;
        currentPair = p;
      }

    }
    // To consider the
    if (currentPair != recentlyAdded)
      result.add(currentPair);
    Collections.sort(result, new IntervalComparator());
    return result;
  }

}


class IntervalComparator implements Comparator<Pair<Integer, Integer>> {

  @Override
  public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {
    return p1.getKey() - p2.getKey();
  }

}
