package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Проверка на упорядоченность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> s = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            s.add(bf.readLine());
        }
        for (int i = 1; i < 10; i++) {
            if (s.get(i).length() < s.get(i - 1).length()) {
                System.out.println(i);
                break;
            }
        }
    }
}

