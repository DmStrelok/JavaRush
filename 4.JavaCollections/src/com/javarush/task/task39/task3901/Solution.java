package com.javarush.task.task39.task3901;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Уникальные подстроки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please input your string: ");
        String s = bufferedReader.readLine();

        System.out.println("The longest unique substring length is: \n" + lengthOfLongestUniqueSubstring(s));
    }

    public static int lengthOfLongestUniqueSubstring(String s) {
        if (s == null || s.equals("")) return 0;
        StringBuilder sb = new StringBuilder(String.valueOf(s.charAt(0)));
        int n = 1;
        for (int i = 1; i < s.length(); i++) {
            int k = sb.toString().indexOf(s.charAt(i));
            sb.append(s.charAt(i));
            if (k != -1) sb = new StringBuilder(sb.substring(k + 1));
            if (sb.length() > n) n = sb.length();
        }
        return n;
    }
}
