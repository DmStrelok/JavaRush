package com.javarush.task.task18.task1825;

import javafx.collections.transformation.SortedList;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> al = new ArrayList<>();
        try {
            for (String s = br.readLine(); !s.equals("end"); s = br.readLine()) {
                al.add(s);
            }
        }
        catch (IOException e) {}
        if (al.size() > 0) {
            String file = al.get(0).substring(0, al.get(0).lastIndexOf(".part"));
            try (FileOutputStream fos = new FileOutputStream(file)) {
                al.stream().sorted().forEach(e -> {
                    try (FileInputStream fis = new FileInputStream(e)) {
                        byte[] b = new byte[fis.available()];
                        fis.read(b);
                        fos.write(b);
                    } catch (IOException ee) {}
                });
            } catch (IOException ee) {}
        }
    }
}
