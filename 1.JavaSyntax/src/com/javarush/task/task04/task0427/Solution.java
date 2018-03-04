package com.javarush.task.task04.task0427;

/* 
Описываем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(bf.readLine());
        if (a > 0 && a < 1000) {
            if (a % 2 == 0) System.out.print("четное ");
            else System.out.print("нечетное ");
            if (a / 100 != 0) System.out.print("трехзначное");
            else if (a / 10 != 0) System.out.print("двузначное");
            else System.out.print("однозначное");
            System.out.println(" число");
        }
    }
}
