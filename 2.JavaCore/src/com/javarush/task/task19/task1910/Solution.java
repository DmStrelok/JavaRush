package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader fis = new BufferedReader(new FileReader(br.readLine()));
             BufferedWriter fos = new BufferedWriter(new FileWriter(br.readLine()))) {
            while (fis.ready()) {
                String s = fis.readLine();
                s = s.replaceAll("\\p{Punct}", "");
                fos.write(s);
            }
        }
        catch (IOException e) {}
    }
}
