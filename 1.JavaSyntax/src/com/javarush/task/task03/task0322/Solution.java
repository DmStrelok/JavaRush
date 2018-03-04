package com.javarush.task.task03.task0322;


/* 
Большая и чистая
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String n1 = bf.readLine();
        String n2 = bf.readLine();
        String n3 = bf.readLine();
        System.out.println(n1 + " + " + n2 + " + " + n3 + " = Чистая любовь, да-да!");
    }
}