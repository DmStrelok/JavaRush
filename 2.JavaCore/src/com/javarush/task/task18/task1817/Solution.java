package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
        if (args.length > 0) {
            try (FileInputStream fis = new FileInputStream(args[0])) {
                int p = 0;
                int n = fis.available();
                while (fis.available() > 0) {
                    if (String.valueOf((char)fis.read()).equals(" ")) p++;
                }
                System.out.printf("%.2f", 100.0 * p / n);
            }
            catch (IOException e) {}
        }

    }
}
