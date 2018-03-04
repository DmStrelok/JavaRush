package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        double sum = 0;
        int n = 0;
        for (int f = Integer.parseInt(bf.readLine()); f != -1;) {
            sum += f;
            n ++;
            f = Integer.parseInt(bf.readLine());
        }
        System.out.println(sum / n);
    }
}

