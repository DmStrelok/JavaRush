package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader fr1 = new BufferedReader(new FileReader(br.readLine()));
             BufferedReader fr2 = new BufferedReader(new FileReader(br.readLine()))) {
            String s1 = "";
            String s2 = "";
            int f = 0;
            String s11, s22;
            if (fr1.ready()) s11 = fr1.readLine();
            else s11 = "";
            if (fr2.ready()) s22 = fr2.readLine();
            else s22 = "";
            while (!s1.equals("") || !s2.equals("") || !s11.equals("") || !s22.equals("")) {
                if (f == 0) {
                    if (fr1.ready()) s1 = fr1.readLine();
                    else s1 = "";
                    if (fr2.ready()) s2 = fr2.readLine();
                    else s2 = "";
                }
                if (f == 1) {
                    if (fr2.ready()) s2 = fr2.readLine();
                    else s2 = "";
                }
                if (f == -1) {
                    if (fr1.ready()) s1 = fr1.readLine();
                    else s1 = "";
                }
                if (s11.equals(s22)) {
                    f = 0;
                    lines.add(new LineItem(Type.SAME, s11));
                    s11 = s1;
                    s1 = "";
                    s22 = s2;
                    s2 = "";
                }
                else {
                    if (s11.equals(s2)) {
                        f = 1;
                        lines.add(new LineItem(Type.ADDED, s22));
                        s22 = s2;
                        s2 = "";
                    }
                    else
                    if (s22.equals(s1)) {
                        f = -1;
                        lines.add(new LineItem(Type.REMOVED, s11));
                        s11 = s1;
                        s1 = "";
                    }
                }
            }
        }
        catch (IOException e) {}
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
