package com.javarush.task.task05.task0529;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Консоль-копилка
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        for (String s = bf.readLine(); "сумма".equals(s) != true; s = bf.readLine()) {
            sum += Integer.parseInt(s);
        }
        System.out.println(sum);
    }
}
