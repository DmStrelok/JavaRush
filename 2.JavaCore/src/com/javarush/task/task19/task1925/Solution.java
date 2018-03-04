package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        if (args.length > 1) {
            try (BufferedReader br = new BufferedReader(new FileReader(args[0]));
                 BufferedWriter bw = new BufferedWriter(new FileWriter(args[1]))){
                String s = "";
                while (br.ready()) {
                    s = s.concat(br.readLine()).concat(" ");
                }
                String[] al =  Arrays.asList(s.split(" "))
                        .stream()
                        .filter(w -> w.length() > 6).toArray(String[]::new);
                if (al.length > 0) bw.write(al[0]);
                for (int i = 1; i < al.length; i++) {
                    bw.write(",".concat(al[i]));
                }
            }
            catch (IOException e) {}
        }
    }
}
