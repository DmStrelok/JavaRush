package com.javarush.task.task19.task1924;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) {
        try (BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader br = new BufferedReader(new FileReader(br2.readLine()))){
            br.lines().collect(Collectors.toList())
                    .stream()
                    .forEach(s -> {
                        Pattern p = Pattern.compile("(\\s|\\p{Punct}|^)(0|(1[0-2])|([0-9]))(\\s|\\p{Punct}|$)");
                        Matcher m = p.matcher(s);
                        while (m.find()) {
                            int n = m.start();
                            int k = m.end();
                            if (!s.substring(n, n + 1).matches("\\d")) n++;
                            if (!s.substring(k - 1, k).matches("\\d")) k--;
                            s = s.substring(0, n).concat(map.get(Integer.parseInt(s.substring(n, k)))).concat(s.substring(k));
                            m = p.matcher(s);
                        }
                        System.out.println(s);
                    });
        }
        catch (IOException e) {}
    }
}
