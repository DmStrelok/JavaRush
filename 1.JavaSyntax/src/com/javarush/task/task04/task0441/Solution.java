package com.javarush.task.task04.task0441;


/* 
Как-то средненько
*/
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(bf.readLine());
        int b = Integer.parseInt(bf.readLine());
        int c = Integer.parseInt(bf.readLine());
        if (a > b) { int d = a; a = b; b = d; }
        if (b > c) { int d = b; b = c; c = d; }
        if (a > b) { int d = a; a = b; b = d; }
        System.out.println(b);


    }
}
