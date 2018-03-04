package com.javarush.task.task10.task1019;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Функциональности маловато!
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Integer> hm = new HashMap<>();
        for (String s = reader.readLine(); !s.isEmpty();) {
            hm.put(reader.readLine(), Integer.parseInt(s));
            s = reader.readLine();
        }
        for (Map.Entry<String, Integer> s : hm.entrySet()) {
            System.out.println(s.getValue() + " " + s.getKey());
        }
    }
}
