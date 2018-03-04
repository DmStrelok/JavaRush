package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             FileReader fr = new FileReader(br.readLine())) {
            int n = 0;
            int k = 0;
            String s = "";
            while (fr.ready()) {
                char[] c = new char[1];
                fr.read(c);
                s = s.concat(String.valueOf(c));
            }
            Pattern ptrn = Pattern.compile("\\bworld\\b");
            Matcher match = ptrn.matcher(s);
            while (match.find()){
                n++;
            }
            System.out.println(n);
        }
        catch (IOException e) {}
    }
}
