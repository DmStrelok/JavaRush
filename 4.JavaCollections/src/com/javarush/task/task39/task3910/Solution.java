package com.javarush.task.task39.task3910;

/* 
isPowerOfThree
*/
public class Solution {
    public static void main(String[] args) {
    }

    public static boolean isPowerOfThree(int n) {
        if (n < 1) return false;
        while (n > 1) {
            if (n % 3 == 0) {
                n /= 3;
            }
            else return false;
        }
        return true;
    }
}