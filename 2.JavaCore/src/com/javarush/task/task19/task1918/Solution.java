package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        if (args.length > 0) {
            String teg = args[0];
            try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                 BufferedReader fis = new BufferedReader(new FileReader(br.readLine()))) {
                ArrayList<Integer> ali = new ArrayList<>();
                ArrayList<String> al = new ArrayList<>();
                StringBuilder s = new StringBuilder();
                while (fis.ready()) {
                    s.append(fis.readLine());
                }
                Pattern p = Pattern.compile(teg);
                Matcher m = p.matcher(s);
                int n = 0;
                while (m.find()) {
                    if (m.start() != 0) {
                        if (s.substring(m.start() - 2, m.end() + 1).equals("</".concat(teg).concat(">"))) {
                            ali.add(m.end() + 1);
                            al.add("e".concat(String.valueOf(n)));
                            n--;
                        }
                        if (s.charAt(m.start() - 1) == '<') {
                            n++;
                            ali.add(m.start() - 1);
                            al.add("s".concat(String.valueOf(n)));
                        }
                    }
                }
                for (int i = 0; i < ali.size(); i++) {
                    if (al.get(i).charAt(0) == 's') {
                        String w = al.get(i);
                        w = w.substring(1, w.length());
                        for (int j = i + 1; j < ali.size(); j++) {
                            if (w.equals(al.get(j).substring(1, al.get(j).length()))) {
                                System.out.println(s.substring(ali.get(i), ali.get(j)));
                                break;
                            }
                        }
                    }
                }
            }
            catch (IOException e) {}
        }
    }
}
