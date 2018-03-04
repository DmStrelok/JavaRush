package com.javarush.task.task32.task3201;

import java.io.IOException;
import java.io.RandomAccessFile;

/*
Запись в существующий файл
*/
public class Solution {
    public static void main(String... args) {
        if (args.length > 2) {
            String fileName = args[0];
            int number = Integer.parseInt(args[1]);
            String text = args[2];
            try {
                RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
                if (number < 0) raf.seek(0);
                else
                    if (number <= raf.length()) {
                        raf.seek(number);
                    }
                    else raf.seek(raf.length());
                raf.write(text.getBytes());
                raf.close();
            } catch (IOException e) {
            }
        }
    }
}
