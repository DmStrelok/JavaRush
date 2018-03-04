package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        if (a <= 0 || b <= 0) throw new ArithmeticException();
        int c = a > b ? b : a;
        int j = 1;
        for (int i = 2; i < c / 2; i++) {
            if (a % i == 0 && b % i == 0) j = i;
        }
        if (a % c == 0 && b % c == 0) j = c;
        System.out.println(j);
    }
}
