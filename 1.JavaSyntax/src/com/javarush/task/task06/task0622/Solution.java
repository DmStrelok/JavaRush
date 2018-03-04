package com.javarush.task.task06.task0622;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Числа по возрастанию
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] a = new int[5];
        for (int i = 0; i < 5; i++) {
            a[i] = Integer.parseInt(reader.readLine());
        }
        for (int i = 0; i < 4; i++) {
            for (int j = i; j < 5; j++) {
                if (a[i] > a[j]) { int b = a[i]; a[i] = a[j]; a[j] = b; }
            }
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(a[i]);
        }

        //напишите тут ваш код
    }
}
