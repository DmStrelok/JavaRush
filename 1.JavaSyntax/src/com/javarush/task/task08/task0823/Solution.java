package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        String s2 = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяabcdefghijklmopqrstuvwxyz";

        if (s2.indexOf(s.charAt(0)) != -1) s = s.substring(0, 1).toUpperCase().concat(s.substring(1));
        for (int i = s.indexOf(" "); (i < s.length() - 2) && (i != -1); i = s.indexOf(" ", i + 1)) {
            if (s2.indexOf(s.charAt(i + 1)) != -1) s = s.substring(0, i + 1).concat(s.substring(i + 1, i + 2).toUpperCase()).concat(s.substring(i + 2));
        }
        if (s2.indexOf(s.charAt(s.length() - 1)) != -1 && " ".equals(s.substring(s.length() - 2, s.length() - 1)))
            s = s.substring(0, s.length()-1).concat(s.substring(s.length() - 1, s.length()).toUpperCase());
        System.out.println(s);
        //напишите тут ваш код
    }
}
