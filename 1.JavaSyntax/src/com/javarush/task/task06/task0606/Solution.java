package com.javarush.task.task06.task0606;

import java.io.*;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int s = Integer.parseInt(bf.readLine());
        while (s > 0) {
            int k = s % 10;
            if (k % 2 == 0) even++;
            else odd++;
            s = s / 10;
        }
        System.out.println("Even: " + even + " Odd: " + odd);
    }
}
