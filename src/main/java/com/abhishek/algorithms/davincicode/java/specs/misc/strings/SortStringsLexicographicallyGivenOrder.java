package com.abhishek.algorithms.davincicode.java.specs.misc.strings;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class SortStringsLexicographicallyGivenOrder {
    //    public static String sortLexicographically(String str,String order){
//
//    }
    public static void main(String args[]) {
        String order="abcdefghijklmnopqrstuvwxyz";
        TreeSet<String> set = new TreeSet<>(new StringComparator(order));
        set.add("abcd");
        set.add("abcde");
        System.out.println(set);
    }
}

class StringComparator implements Comparator<String> {
    private String order;
    private Map<Character, Integer> map;

    public StringComparator(String order) {
        this.order = order;
        this.map = new HashMap<>();
        for (int i = 0; i < order.length(); i++)
            map.put(order.charAt(i), i);
    }

    @Override
    public int compare(String s1, String s2) {
        int m = s1.length(), n = s2.length(), i = 0, j = 0;
        while (i < m && j < n) {
            int iIndex = map.get(s1.charAt(i));
            int jIndex = map.get(s2.charAt(j));
            if (iIndex < jIndex)
                return -1;
            else if (iIndex > jIndex)
                return 1;
            i++;
            j++;
        }
        if (i < m)
            return 1;
        else if (j < n)
            return -1;
        return 0;
    }
}
