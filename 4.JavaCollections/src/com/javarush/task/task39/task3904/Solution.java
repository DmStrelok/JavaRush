package com.javarush.task.task39.task3904;

import java.util.ArrayList;
import java.util.List;

/*
Лестница
*/
public class Solution {
    private static List<Long> list = new ArrayList<>();
    static {
        list.add(1L);
        list.add(1L);
        list.add(2L);
    }
    private static int n = 70;
    public static void main(String[] args) {
        System.out.println("Number of possible runups for " + n + " stairs is: " + countPossibleRunups(n));
    }

    public static long countPossibleRunups(int n) {
        if (n < 0) return 0;
        if (n == 0) return 1;
        if (n == 1) return 1;
        if (n == 2) return 2;
        long n1;
        if (list.size() >= n) n1 = list.get(n - 1);
        else {
            n1 = countPossibleRunups(n - 1);
            list.add(n1);
        }
        long n2 = list.get(n - 2);
        long n3 = list.get(n - 3);

        return n1 + n2 + n3;
    }
}

