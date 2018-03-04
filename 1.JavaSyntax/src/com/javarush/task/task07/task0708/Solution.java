package com.javarush.task.task07.task0708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Самая длинная строка
*/

public class Solution {
    private static List<String> strings;

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        strings = new ArrayList<String>();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        strings.add(bf.readLine());
        int s2 = strings.get(0).length();
        for (int i = 1; i < 5; i++) {
            strings.add(bf.readLine());
            if (s2 < strings.get(i).length()) s2 = strings.get(i).length();
        }

        for (int i = 0; i < 5; i++) {
            if (s2 == strings.get(i).length()) System.out.println(strings.get(i));
        }
    }
}
