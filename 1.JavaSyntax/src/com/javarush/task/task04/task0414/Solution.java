package com.javarush.task.task04.task0414;

/* 
Количество дней в году
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        if (((n % 4 == 0) && (n % 100 != 0)) || (n % 400 == 0)) System.out.println("количество дней в году: 366");
        else System.out.println("количество дней в году: 365");
    }
}