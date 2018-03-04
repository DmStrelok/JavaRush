package com.javarush.task.task07.task0703;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Общение одиноких массивов
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        String[] s = new String[10];
        int[] a = new int[10];
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            s[i] = bf.readLine();
            a[i] = s[i].length();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(a[i]);
        }
    }
}
