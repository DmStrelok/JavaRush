package com.javarush.task.task04.task0420;

/* 
Сортировка трех чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(bf.readLine());
        int b = Integer.parseInt(bf.readLine());
        int c = Integer.parseInt(bf.readLine());
        if ((a < b) && (a < c)) { int f = c; c = a; a = f;}
        if (a < b) { int f = b; b = a; a = f;}
        if (b < c) { int f = b; b = c; c = f;}
        if (a < b) { int f = b; b = a; a = f;}
        System.out.println(a + " " + b + " " + c);
    }
}
