package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader fr = new BufferedReader(new FileReader(br.readLine()))) {
            while (fr.ready()) {
                String s = fr.readLine();
                int k = 0;
                for (int i = 0; i < words.size(); i++) {
                    Pattern p = Pattern.compile("([\\s\\p{Punct}]|^)" + words.get(i) + "([\\s\\p{Punct}]|$)");
                    Matcher m = p.matcher(s);
                    while (m.find()) {
                        k++;
                    }
                    if (k > 2) break;
                }
                if (k == 2) System.out.println(s);
            }
        }
        catch (IOException e) {}
    }
}
