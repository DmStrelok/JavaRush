package com.javarush.task.task32.task3210;

import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) {
        if (args.length > 2) {
            String fileName = args[0];
            int number = Integer.parseInt(args[1]);
            String text = args[2];
            try (RandomAccessFile raf = new RandomAccessFile(fileName, "rw")) {
                boolean bb = false;
                if (number >= 0) {
                    byte[] b = new byte[text.length()];
                    raf.seek(number);
                    raf.read(b, 0, text.length());
                    String s = convertByteToString(b);
                    if (s.equals(text)) bb = true;
                }
                raf.seek(raf.length());
                raf.write(String.valueOf(bb).getBytes());
            } catch (IOException e) {
            }
        }
    }

    public static String convertByteToString(byte readBytes[]) {
        return new String(readBytes);
    }
}
