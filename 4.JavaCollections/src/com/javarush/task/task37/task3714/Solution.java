package com.javarush.task.task37.task3714;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Древний Рим
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input a roman number to be converted to decimal: ");
        String romanString = bufferedReader.readLine();
        System.out.println("Conversion result equals " + romanToInteger(romanString));
    }

    public static int romanToInteger(String s) {
        s = s.toUpperCase();
        int[] n = new int[s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'M': n[i] = 7; break;
                case 'D': n[i] = 6; break;
                case 'C': n[i] = 5; break;
                case 'L': n[i] = 4; break;
                case 'X': n[i] = 3; break;
                case 'V': n[i] = 2; break;
                case 'I': n[i] = 1; break;
            }
        }
        n[s.length()] = 0;

        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (n[i]) {
                case 7: sum += 1000; break;
                case 6: {
                    if (n[i] < n[i + 1]) sum -= 500;
                    else sum += 500;
                } break;
                case 5: {
                    if (n[i] < n[i + 1]) sum -= 100;
                    else sum += 100;
                } break;
                case 4: {
                    if (n[i] < n[i + 1]) sum -= 50;
                    else sum += 50;
                } break;
                case 3: {
                    if (n[i] < n[i + 1]) sum -= 10;
                    else sum += 10;
                } break;
                case 2: {
                    if (n[i] < n[i + 1]) sum -= 5;
                    else sum += 5;
                } break;
                case 1: {
                    if (n[i] < n[i + 1]) sum -= 1;
                    else sum += 1;
                } break;
            }
        }
        return sum;
    }
}
