package com.javarush.task.task39.task3912;

/* 
Максимальная площадь
*/

public class Solution {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 1, 1, 0, 0},
                {1, 0, 0, 1, 0, 0},
                {0, 1, 1, 1, 1, 1},
                {1, 0, 1, 1, 1, 1},
                {1, 0, 0, 1, 1, 1}};
        System.out.println(maxSquare(matrix));
    }

    public static int maxSquare(int[][] matrix) {
        int square = 0;
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] > 0) {
                    int z1 = 0;
                    int z2 = 0;
                    if (j > 0) {
                        z1 = matrix[i][j - 1];
                        z2 = matrix[i - 1][j - 1];
                    }
                    int z3 = matrix[i - 1][j];
                    z1 = z1 < z2 ? z1 : z2;
                    z1 = z1 < z3 ? z1 : z3;
                    if (matrix[i][j] <= z1) matrix[i][j] = z1 + 1;
                    if (z1 >= square) square = z1 + 1;
                }
            }
        }
        return square * square;
    }

    // не проходит по времени

   /* public static int maxSquare(int[][] matrix) {
        int square = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    int k = square(matrix, i, j, square);
                    if (k > square) square = k;
                }
            }
        }
        return square * square;
    }

    public static int square(int[][] matrix, int x, int y, int sq) {
        int z1 = matrix.length - x;
        int z2 = matrix[0].length - y;
        int k = z1 < z2 ? z1 : z2;
        for (int l = k; l > sq; l--) {
            int d = 0;
            l1: {
                for (int i = 0; i < l; i++) {
                    for (int j = 0; j < l; j++) {
                        if (matrix[x + i][y + j] == 0) break l1;
                        else d++;
                    }
                }
            }
            if (l*l - d == 0) return l;
        }
        return 0;
    }*/
}
