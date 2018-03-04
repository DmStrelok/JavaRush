package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(bf.readLine());
        int m = fis.read();
        while (fis.available() > 0) {
            int b = fis.read();
            if (b < m) m = b;
        }
        System.out.println(m);
        fis.close();
        bf.close();
    }
}
