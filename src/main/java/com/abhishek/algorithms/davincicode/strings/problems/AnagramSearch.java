package com.abhishek.algorithms.davincicode.strings.problems;

import java.util.HashSet;
import java.util.Set;

public class AnagramSearch {

    public static void main(String[] args) {
        AnagramSearch myClass = new AnagramSearch();
        System.out.println(myClass.isAnagram("geeksforgeeks", "rseek"));
        System.out.println(myClass.isAnagram2("geeksforgeeks", "frog"));
    }

    public boolean isAnagram2(String txt, String pat) {
        int M = pat.length(), N = txt.length(), j = 0;
        for (int i = 0; i <= N - M; i++) {
            if (j == M)
                return true;
            if (pat.contains(txt.charAt(i) + "")) {
                j++;
            } else {
                j = 0;
            }
        }
        return false;
    }

    public boolean isAnagram(String txt, String pat) {
        Set<String> set = permuteString(pat, 0, pat.length() - 1, new HashSet<String>());
        for (String s : set) {
            if (txt.contains(s)) {
                return true;
            }
        }
        return false;
    }

    public Set<String> permuteString(String s, int l, int r, Set<String> result) {
        if (l == r)
            result.add(s);

        for (int i = l; i <= r; i++) {
            s = swap(s, l, i);
            result = permuteString(s, l + 1, r, result);
        }
        return result;
    }

    public String swap(String str, int newIndex, int oldIndex) {
        char[] arr = str.toCharArray();
        int val = arr[oldIndex];
        arr[oldIndex] = arr[newIndex];
        arr[newIndex] = (char) val;
        str = String.valueOf(arr);
        return str;
    }

}
