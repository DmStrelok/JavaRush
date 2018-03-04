package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String nf = bf.readLine();
        FileInputStream fis = new FileInputStream(nf);
        int m = 0;
        while (fis.available() > 0) {
            int b = fis.read();
            if (b > m) m = b;
        }
        System.out.println(m);
        fis.close();
        bf.close();
    }
}
