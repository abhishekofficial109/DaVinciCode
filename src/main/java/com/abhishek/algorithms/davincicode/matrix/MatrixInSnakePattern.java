package com.abhishek.algorithms.davincicode.matrix;

public class MatrixInSnakePattern {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int rows = 4;
        int columns = 4;
        matrixInSnakePattern(matrix, rows, columns);
    }

    public static void matrixInSnakePattern(int[][] matrix, int rows, int columns) {
        for (int i = 0; i < rows; i++) {
            if ((i + 1) % 2 == 0) {
                for (int j = columns - 1; j >= 0; j--) {
                    System.out.print(matrix[i][j] + ",");
                }
            } else {
                for (int j = 0; j < columns; j++) {
                    System.out.print(matrix[i][j] + ",");
                }
            }
        }
    }

}
