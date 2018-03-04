package com.javarush.task.task20.task2025;

import java.util.ArrayList;

/*
Алгоритмы-числа
*/
public class Solution {
    public static long[] Mpow(int m){
        long[] l = new long[10];
        m++;
        for (int i = 0; i < 10; i++) {
            l[i] = (long) Math.pow(i, m);
        }
        return l;
    }

    public static long[] getNumbers(long N) {
        long[] result = null;
        ArrayList<Long> al = new ArrayList<>();
        byte[] alb = new byte[40];
        alb[0] = 0;
        int m = 0;
        long n = 0;
        long[] pow = Mpow(m);
        int b = 0;
        for (long i = 1; i < N; i++) {
            while (true) {
                byte a = (byte) (alb[b] + 1);
                if (a > 9) {
                    n -= pow[9];
                    alb[b] = 0;
                    b++;
                    if (b > m) {m = b; pow = Mpow(m);}
                }
                else {
                    n = n - pow[a - 1] + pow[a];
                    alb[b] = a;
                    b = 0;
                    break;
                }
            }
            if (n == i) al.add(i);
        }

        result = new long[al.size()];
        for (int i = 0; i < al.size(); i++) {
            result[i] = al.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        /*long[] l = getNumbers(Long.MAX_VALUE);
        for (int i = 0; i < l.length; i++) {
            System.out.println(l[i]);
        }*/
    }
}
