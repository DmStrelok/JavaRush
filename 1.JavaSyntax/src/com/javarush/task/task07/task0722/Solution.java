package com.javarush.task.task07.task0722;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Это конец
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> s = new ArrayList<>();
        String e = reader.readLine();
        for (;!e.equals("end");) {
            s.add(e);
            e = reader.readLine();
        }
        for (int i = 0; i < s.size(); i++) {
            System.out.println(s.get(i));
        }
        //напишите тут ваш код
    }
}