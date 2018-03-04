package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             FileReader fr = new FileReader(br.readLine());
             FileWriter fw = new FileWriter(br.readLine())) {
            int n = 0;
            while (fr.ready()) {
                n++;
                int b = fr.read();
                if (n % 2 == 0) fw.write(b);
            }
        }
        catch (IOException e) {}
    }
}
