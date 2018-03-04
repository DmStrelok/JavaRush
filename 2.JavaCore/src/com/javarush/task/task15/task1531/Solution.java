package com.javarush.task.task15.task1531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

/* 
Факториал
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        reader.close();

        System.out.println(factorial(input));
    }

    public static String factorial(int n) {
        //add your code here
        BigDecimal l = new BigDecimal(1);
        if (n < 0) l = new BigDecimal(0);
        else if (n == 0) l = new BigDecimal(1);
        else
            for (int i = 1; i <= n; i++) {
                l = l.multiply(new BigDecimal(i));
            }
        return String.valueOf(l);
    }
}
