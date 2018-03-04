package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader fis = new BufferedReader(new FileReader(br.readLine()));
             BufferedWriter fos = new BufferedWriter(new FileWriter(br.readLine()))) {
            while (fis.ready()) {
                String s = fis.readLine();
                s = s.replaceAll("\\.", "!");
                fos.write(s);
                fos.newLine();
            }
        }
        catch (IOException e) {}

    }
}
