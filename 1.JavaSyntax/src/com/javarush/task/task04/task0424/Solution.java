package com.javarush.task.task04.task0424;

/* 
Три числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(bf.readLine());
        int b = Integer.parseInt(bf.readLine());
        int c = Integer.parseInt(bf.readLine());
        if ((a != b) && (b == c)) System.out.println("1");
        if ((b != a) && (a == c)) System.out.println("2");
        if ((c != a) && (a == b)) System.out.println("3");

    }
}
