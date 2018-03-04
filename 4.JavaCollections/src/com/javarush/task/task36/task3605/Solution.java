package com.javarush.task.task36.task3605;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;

/* 
Использование TreeSet
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length > 0) {
            TreeSet<Character> treeSet = new TreeSet<>();
            try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
                String a = "abcdefgkjiklmnopqrstuvwxyz";
                while (br.ready()) {
                    String s = br.readLine().toLowerCase();
                    for (int i = 0; i < s.length(); i++) {
                        if (a.indexOf(s.charAt(i)) != -1) treeSet.add(s.charAt(i));
                    }
                }
            }
            int i = 0;
            for (Character c : treeSet) {
                System.out.print(c);
                if (++i == 5) break;
            }
        }
    }
}
