package com.javarush.task.task18.task1809;

/* 
Реверс файла
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
        try {
            String f1 = bf.readLine();
            String f2 = bf.readLine();
            fis = new FileInputStream(f1);
            fos1 = new FileOutputStream(f2);
            byte[] b = new byte[fis.available()];
            int n = fis.read(b);
            for (int i = b.length - 1; i >= 0; i--) {
                fos1.write(b[i]);
            }
        }
        catch (Exception e) {}
        finally {
            try {
                fis.close();
                fos1.close();

            }
            catch (Exception e) {}
        }
    }
}
