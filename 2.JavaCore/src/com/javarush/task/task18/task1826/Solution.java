package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
        if (args.length > 0) {
            if (args[0].equals("-e")) cr(args);
            if (args[0].equals("-d")) cr(args);
        }
    }
    static void cr (String[] args) {
        try (FileInputStream fis = new FileInputStream(args[1]);
             FileOutputStream fos = new FileOutputStream(args[2])) {
            while (fis.available() > 0) {
                byte b = (byte) fis.read();
                b ^= (1<<7);
                fos.write(b);
            }
        }
        catch (IOException e) {}
    }
}
