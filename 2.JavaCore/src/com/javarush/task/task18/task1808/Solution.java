package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = null;
        FileOutputStream fos1 = null;
        FileOutputStream fos2 = null;
        try {
            String f1 = bf.readLine();
            String f2 = bf.readLine();
            String f3 = bf.readLine();
            fis = new FileInputStream(f1);
            fos1 = new FileOutputStream(f2);
            fos2 = new FileOutputStream(f3);
            int n = fis.available() / 2;
            if (fis.available() % 2 == 1) n++;
            byte[] b1 = new byte[n];
            n = fis.read(b1);
            fos1.write(b1, 0, n);
            byte[] b2 = new byte[fis.available()];
            n = fis.read(b2);
            fos2.write(b2, 0, n);
        }
        catch (Exception e) {}
        finally {
            try {
                fis.close();
                fos1.close();
                fos2.close();
            }
            catch (Exception e) {}
        }
    }
}
