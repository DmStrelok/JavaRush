package com.javarush.task.task04.task0415;

/* 
Правило треугольника
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        double a = Double.parseDouble(bf.readLine());
        double b = Double.parseDouble(bf.readLine());
        double c = Double.parseDouble(bf.readLine());
        if ((a + b > c) && (a + c > b) && (c + b > a)) System.out.println("Треугольник существует.");
        else System.out.println("Треугольник не существует.");
    }
}