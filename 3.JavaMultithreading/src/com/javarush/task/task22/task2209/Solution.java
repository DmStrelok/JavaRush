package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) {
        //...
        StringBuilder sb = new StringBuilder("");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader fis = new BufferedReader(new FileReader(br.readLine()))) {
            while (fis.ready()) {
                sb.append(fis.readLine()).append(" ");
            }
        }
        catch (IOException e) {}
        StringBuilder result = getLine(sb.toString().split(" "));
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        if (words == null || words.length < 1) return new StringBuilder("");
        ArrayList<String> ww = new ArrayList<>();
        Collections.addAll(ww, words);
        StringBuilder sb = new StringBuilder(ww.get(0));
        ww.remove(0);
        while (ww.size() > 0) {
            char cn = sb.toString().toLowerCase().charAt(0);
            char ck = sb.toString().toLowerCase().charAt(sb.length() - 1);
            int i = 0;
            for (; i < ww.size(); i++) {
                if (ww.get(i).toLowerCase().charAt(0) == ck) {
                    sb = sb.append(" ").append(ww.get(i));
                    ww.remove(i);
                    i = -1;
                    break;
                }
                if (ww.get(i).toLowerCase().charAt(ww.get(i).length() - 1) == cn) {
                    sb = new StringBuilder(ww.get(i)).append(" ").append(sb);
                    ww.remove(i);
                    i = -1;
                    break;
                }
            }
            if (i != -1) break;
        }
        for (int i = 0; i < ww.size(); i++) {
            sb.append(" ").append(ww.get(i));
        }
        return sb;
    }
}
