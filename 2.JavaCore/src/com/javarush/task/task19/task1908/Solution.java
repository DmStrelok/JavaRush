package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader fis = new BufferedReader(new FileReader(br.readLine()));
             BufferedWriter fos = new BufferedWriter(new FileWriter(br.readLine()))) {
            while (fis.ready()) {
                String s = fis.readLine();
                Pattern ptrn = Pattern.compile("\\b\\d+\\b");
                Matcher mtcr = ptrn.matcher(s);
                while (mtcr.find()) {
                    fos.write(s.substring(mtcr.start(), mtcr.end()).concat(" "));
                }
            }
        }
        catch (IOException e) {}
    }
}
