package com.javarush.task.task32.task3202;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

/* 
Читаем из потока
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer;
        try {
            writer = getAllDataFromInputStream(new FileInputStream("testFile.log"));
        } catch (IOException e) {
            writer = getAllDataFromInputStream(null);
        }
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        StringWriter sw = new StringWriter();
        if (is != null)
            while (is.available() > 0) {
                sw.write(is.read());
            }
        return sw;
    }
}