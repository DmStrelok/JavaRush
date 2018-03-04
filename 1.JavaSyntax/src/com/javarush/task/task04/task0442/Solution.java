package com.javarush.task.task04.task0442;


/* 
Суммирование
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int s = 0;
        for (int n = 0; n != -1; n = Integer.parseInt(bf.readLine())) {
            s += n;
        }
        System.out.println(s - 1);
    }
}
