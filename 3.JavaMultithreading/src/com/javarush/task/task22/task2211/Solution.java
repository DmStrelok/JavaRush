package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length > 1) {
            try (FileInputStream fis = new FileInputStream(args[0]);
                 FileOutputStream fos = new FileOutputStream(args[1])) {
                Charset cfis = Charset.forName("Windows-1251");
                Charset cfos = Charset.forName("UTF-8");
                byte[] b = new byte[fis.available()];
                fis.read(b);
                String s = new String(b, cfos);
                b = s.getBytes(cfis);
                fos.write(b);
            }
            catch (IOException e) {}
        }
    }
}
