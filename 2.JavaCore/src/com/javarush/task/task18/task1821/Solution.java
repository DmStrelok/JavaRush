package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        if (args.length > 0) {
            try (FileInputStream fis = new FileInputStream(args[0])) {
                Map<Integer, Integer> hm = new TreeMap<>();
                while (fis.available() > 0) {
                    int n = fis.read();
                    if (!hm.containsKey(n)) hm.put(n, 0);
                    hm.put(n, hm.get(n) + 1);
                }
                for (Map.Entry<Integer, Integer> p : hm.entrySet()) {
                    int n = p.getKey();
                    System.out.println((char) n + " " + p.getValue());
                }
            }
            catch (IOException e) {}
        }
    }
}
