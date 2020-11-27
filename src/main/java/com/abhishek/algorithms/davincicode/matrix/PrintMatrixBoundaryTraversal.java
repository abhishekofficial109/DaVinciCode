package com.abhishek.algorithms.davincicode.matrix;

public class PrintMatrixBoundaryTraversal {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int rows = 4;
        int columns = 4;
        matrixBoundaryTraversal(matrix, rows, columns);
    }

    public static void matrixBoundaryTraversal(int[][] matrix, int rows, int columns) {
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrix[i][j] + ",");
            }
        }
        for (int i = 1; i < rows - 1; i++) {
            System.out.print(matrix[i][columns - 1] + ",");
        }
        for (int i = rows - 1; i > rows - 2; i--) {
            for (int j = columns - 1; j >= 0; j--) {
                System.out.print(matrix[i][j] + ",");
            }
        }
        for (int i = rows - 2; i >= 1; i--) {
            System.out.print(matrix[i][0] + ",");
        }
    }

}
