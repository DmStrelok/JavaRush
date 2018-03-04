package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] a = new int[15];
        int c = 0, nc = 0;
        for (int i = 0; i < 15; i++) {
            a[i] = Integer.parseInt(bf.readLine());
            if (i % 2 == 0) c+= a[i];
            else nc += a[i];
        }
        if (c > nc) System.out.println("В домах с четными номерами проживает больше жителей.");
        else System.out.println("В домах с нечетными номерами проживает больше жителей.");
    }
}
