package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        if (args.length > 0) {
            try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
                TreeMap<String, Double> tm = new TreeMap<>();
                while (br.ready()) {
                    String[] s = br.readLine().split(" ");
                    if (tm.get(s[0]) == null) tm.put(s[0], 0d);
                    tm.put(s[0], tm.get(s[0]) + Double.parseDouble(s[1]));
                }
                tm.entrySet().stream().forEach(e -> System.out.println(e.getKey() + " " + e.getValue()));
            } catch (IOException e) {}
        }
    }
}
