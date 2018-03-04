package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader br = new BufferedReader(new FileReader(br2.readLine()))){
            br.lines().collect(Collectors.toList())
                    .stream()
                    .forEach(s -> {
                        StringBuffer sb = new StringBuffer(s);
                        sb.reverse();
                        System.out.println(sb);
                    });
        }
        catch (IOException e) {}
    }
}
