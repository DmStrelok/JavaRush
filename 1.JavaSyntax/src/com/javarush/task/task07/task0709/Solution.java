package com.javarush.task.task07.task0709;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Выражаемся покороче
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> s = new ArrayList<String>();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        s.add(bf.readLine());
        int m = s.get(0).length();
        for (int i = 1; i < 5; i++) {
            s.add(bf.readLine());
            if (m > s.get(i).length()) m = s.get(i).length();
        }
        for (int i = 0; i < 5; i++) {
            if (m == s.get(i).length()) System.out.println(s.get(i));
        }
    }
}
