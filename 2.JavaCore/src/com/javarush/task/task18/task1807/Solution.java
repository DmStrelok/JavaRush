package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try (FileInputStream fis = new FileInputStream(bf.readLine())) {
            StringBuilder sb = new StringBuilder();
            while (fis.available() > 0) {
                sb.append((char) fis.read());
            }
            int n = 0;
            for (int i = 0; i < sb.length(); i++) {
                if (',' == (sb.charAt(i))) n++;
            }
            System.out.println(n);
        } catch (IOException e) {
        }

    }
}
