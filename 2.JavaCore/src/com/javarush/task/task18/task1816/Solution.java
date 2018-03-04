package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        if (args.length > 0) {
            String s = "qazxswedcvfrtgbnhyujmkiolpQAZXSWEDCVFRTGBNHYUJMKIOLP";
            int n = 0;
            try (FileInputStream fis = new FileInputStream(args[0])) {
                while (fis.available() > 0) {
                    if (s.contains(String.valueOf((char)fis.read()))) n++;
                }
            }
            catch (IOException e) {}
            System.out.println(n);
        }
    }
}
