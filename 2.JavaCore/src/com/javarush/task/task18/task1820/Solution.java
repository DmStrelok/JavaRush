package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String file1 = br.readLine();
            String file2 = br.readLine();
            try (BufferedReader br2 = new BufferedReader(new FileReader(file1));
                 BufferedWriter bw = new BufferedWriter(new FileWriter(file2));) {
                String s = br2.readLine();
                Arrays.stream(s.split(" ")).forEach(d -> {
                    try {
                        bw.write(String.valueOf(Math.round(Double.parseDouble(d)) + " "));
                    } catch (IOException e) {}
                });
            }
        }
        catch (IOException e) {}

    }
}
