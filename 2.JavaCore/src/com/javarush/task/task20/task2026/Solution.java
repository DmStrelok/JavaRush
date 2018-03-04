package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        int count = getRectangleCount(a);
        System.out.println("count = " + count + ". Должно быть 2");
    }

    public static int getRectangleCount(byte[][] a) {
        int n = a.length;
        int m = a[0].length;
        int k = 0;
        if (a[0][0] == 1) k++;
        for (int i = 1; i < m; i++) {
            if (a[0][i] == 1 && a[0][i - 1] != 1) k++;
        }
        for (int i = 1; i < n; i++) {
            if (a[i][0] == 1 && a[i - 1][0] != 1) k++;
            for (int j = 1; j < m; j++) {
                if (a[i][j] == 1 && a[i - 1][j] != 1 && a[i][j - 1] != 1) k++;
            }
        }

        return k;
    }
}
