package com.javarush.task.task39.task3908;

/* 
Возможен ли палиндром?
*/
public class Solution {
    public static void main(String[] args) {
    }

    public static boolean isPalindromePermutation(String s) {
        int[] ss = new int[128];
        s = s.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            ss[c]++;
        }
        int k = 0;
        for (int i = 0; i < 128; i++) {
            if (ss[i] % 2 == 1) k++;
        }
        return k < 2;
    }
}
