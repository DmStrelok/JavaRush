package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) {
        //add your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        try {
            s = br.readLine();
        } catch (IOException e) {}
        Pattern p = Pattern.compile("\\?.+$");
        Matcher m = p.matcher(s);
        if (m.find()) {
            int k = m.end();
            s = s.substring(m.start() + 1, k);
            ArrayList<String> ss = new ArrayList<>();
            while (s.length() != 0) {
                int q1 = s.indexOf('=');
                int q2 = s.indexOf('&');
                String s2 = "";

                if (q1 != -1 && (q1 < q2 || q2 == -1)) {
                    s2 = s.substring(0, q1);
                    if (s2.equals("obj") && q1 != s.length() - 1)
                        if (q2 == -1) ss.add(s.substring(q1 + 1, s.length()));
                    else ss.add(s.substring(q1 + 1, q2));
                    if (q2 != -1) s = s.substring(q2 + 1, s.length());
                    else s = "";
                }
                else if (q2 != -1 && (q2 < q1 || q1 == -1)) {
                    s2 = s.substring(0, q2);
                    s = s.substring(q2 + 1, s.length());
                }
                else { s2 = s; s = "";}
                System.out.print(s2.concat(" "));
            }

            System.out.println();
            for (int i = 0; i < ss.size(); i++) {
                p = Pattern.compile("-?\\d+\\.?\\d+");
                m = p.matcher(ss.get(i));
                if (m.matches()) alert(Double.parseDouble(ss.get(i)));
                else alert(ss.get(i));
            }
        }

    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
