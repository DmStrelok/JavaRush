package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        if (args.length > 1) {
            try (BufferedReader br = new BufferedReader(new FileReader(args[0]));
                 BufferedWriter bw = new BufferedWriter(new FileWriter(args[1]))){
                br.lines().collect(Collectors.toList())
                        .stream()
                        .forEach(s -> Arrays.asList(s.split(" "))
                                .stream()
                                .forEach(w -> {
                                    Pattern p = Pattern.compile("\\d");
                                    Matcher m = p.matcher(w);
                                    if (m.find()) try {
                                        bw.write(w.concat(" "));
                                    } catch (IOException e1) {}
                                }));
            }
            catch (IOException e) {}
        }
    }
}
