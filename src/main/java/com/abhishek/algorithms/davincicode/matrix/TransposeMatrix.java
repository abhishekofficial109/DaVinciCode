package com.abhishek.algorithms.davincicode.matrix;

public class TransposeMatrix {

    public static void main(String args[]) {

    }

    public static void transpose_1(int[][] matrix, int rows, int columns) {
        int[][] temp = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                temp[j][i] = matrix[i][j];
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = temp[i][j];
            }
        }
    }

}
