package com.abhishek.algorithms.davincicode.dynamicprogramming.assemblylinescheduling;

/*
 * Source: https://www.geeksforgeeks.org/assembly-line-scheduling-dp-34/
 */
public class AssemblyLinedScheduling {

    private int subStation;
    private int assemblies;

    public AssemblyLinedScheduling(int subStation, int assemblies) {
        super();
        this.subStation = subStation;
        this.assemblies = assemblies;
    }

    public static void main(String[] args) {
        int assemblies[][] = {{4, 5, 3, 2}, {2, 10, 1, 4}};
        int transfers[][] = {{0, 7, 4, 5}, {0, 9, 2, 8}};
        int entry[] = {10, 12}, exit[] = {18, 7};
        AssemblyLinedScheduling assemblyLinedScheduling = new AssemblyLinedScheduling(4, 2);
        int find = assemblyLinedScheduling.minimumTimeRequiredToAssembleChassis(assemblies, transfers,
                entry, exit);
        System.out.println(find);
    }

    private int minimumTimeRequiredToAssembleChassis(int[][] assemblies, int[][] transfer, int[] e,
                                                     int[] x) {
        assemblies[0][0] = assemblies[0][0] + e[0];
        assemblies[1][0] = assemblies[0][0] + e[1];
        assemblies[0][3] = assemblies[0][3] + x[0];
        assemblies[1][3] = assemblies[1][3] + x[1];

        return fun(assemblies, transfer, e, x, 0, 0);
    }

    private int fun(int[][] assemblies, int[][] transfer, int[] e, int[] x, int n, int row) {
        if (n == subStation || row == this.assemblies)
            return 0;
        int[] minArr = new int[this.assemblies];
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < this.assemblies; i++) {
            for (int j = n; j < this.subStation; j++) {
                int val = ((j == row) ? assemblies[j][n] : assemblies[j][n] + transfer[j][n])
                        + fun(assemblies, transfer, e, x, j, i);
                min = Math.min(min, val);
            }
            minArr[i] = min;
            min = Integer.MAX_VALUE;
        }
        min = Integer.MAX_VALUE;
        for (int i = 0; i < this.assemblies; i++) {
            min = Math.min(min, minArr[i]);
        }
        return min;
    }

}
