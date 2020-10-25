package com.abhishek.algorithms.davincicode.dynamicprogramming.longestsnakesequence;

import java.util.LinkedList;
import java.util.List;

import com.abhishek.algorithms.davincicode.util.Pair;

public class LongestSnakeSequence {

  public static void main(String[] args) {
    int mat[][] = {{9, 6, 5, 2}, {8, 7, 6, 5}, {7, 3, 1, 6}, {1, 1, 1, 7}};

    List<Pair<Integer, Integer>> list =
        longestSnakeSequence(mat, 4, 4, 0, 0, new LinkedList<Pair<Integer, Integer>>());
    System.out.println(list);
    for (Pair<Integer, Integer> pair : list) {
      System.out.print(mat[pair.getKey()][pair.getValue()] + ",");
    }
  }

  private static List<Pair<Integer, Integer>> longestSnakeSequence(int[][] matrix, int row,
      int column, int i, int j, List<Pair<Integer, Integer>> l) {
    if (i == row || j == column)
      return l;
    List<Pair<Integer, Integer>> right = l;
    if (j + 1 != column
        && (matrix[i][j] + 1 == matrix[i][j + 1] || matrix[i][j] - 1 == matrix[i][j + 1])) {
      l.add(new Pair<Integer, Integer>(i, j));
      right = longestSnakeSequence(matrix, row, column, i, j + 1, right);
    }
    List<Pair<Integer, Integer>> down = l;
    if (i + 1 != row
        && (matrix[i][j] + 1 == matrix[i + 1][j] || matrix[i][j] - 1 == matrix[i + 1][j])) {
      l.add(new Pair<Integer, Integer>(i, j));
      down = longestSnakeSequence(matrix, row, column, i + 1, j, down);
    }

    if (right.size() > down.size())
      return right;
    return down;
  }

}
