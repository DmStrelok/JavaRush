package com.javarush.task.task04.task0412;

/* 
Положительное и отрицательное число
*/

import javax.swing.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(bf.readLine());

        if (a > 0) a<<=1;
        if (a < 0) a ++;
        System.out.println(a);

    }

}