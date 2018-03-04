package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String file1 = br.readLine();
            String file2 = br.readLine();
            try (FileInputStream fis = new FileInputStream(file1);) {
                byte[] b = new byte[fis.available()];
                fis.read(b);
                fis.close();
                try (FileOutputStream fos = new FileOutputStream(file1);
                     FileInputStream fis2 = new FileInputStream(file2)) {
                    byte[] b2 = new byte[fis2.available()];
                    fis2.read(b2);
                    fos.write(b2);
                    fos.write(b);
                }
            }
        }
        catch (IOException e) {}
    }
}
