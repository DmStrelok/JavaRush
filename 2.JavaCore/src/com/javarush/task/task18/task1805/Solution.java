package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(bf.readLine());
        ArrayList<Integer> al = new ArrayList<>();
        while (fis.available() > 0) {
            al.add(fis.read());
        }
        fis.close();
        al.stream().sorted().distinct().forEach(e -> System.out.print(e + " "));
        System.out.println();
    }
}
