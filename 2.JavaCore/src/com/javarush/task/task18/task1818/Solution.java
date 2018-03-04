package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String file1 = "";
        String file2 = "";
        String file3 = "";
        try {
            file1 = br.readLine();
            file2 = br.readLine();
            file3 = br.readLine();
        }
        catch (IOException e) {}
        try (FileOutputStream fos = new FileOutputStream(file1);
             FileInputStream fis = new FileInputStream(file2);
             FileInputStream fis2 = new FileInputStream(file3);) {
            while (fis.available() > 0) {
                fos.write(fis.read());
            }
            while (fis2.available() > 0) {
                fos.write(fis2.read());
            }
        }
        catch (IOException e) {}
    }
}
