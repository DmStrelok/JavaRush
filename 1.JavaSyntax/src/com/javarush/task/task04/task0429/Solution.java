package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(bf.readLine());
        int b = Integer.parseInt(bf.readLine());
        int c = Integer.parseInt(bf.readLine());
        int i = 0, i2 = 0;
        if (a > 0) i++;
        if (b > 0) i++;
        if (c > 0) i++;
        if (a < 0) i2++;
        if (b < 0) i2++;
        if (c < 0) i2++;
        System.out.println("количество отрицательных чисел: " + i2);
        System.out.println("количество положительных чисел: " + i);

    }
}
