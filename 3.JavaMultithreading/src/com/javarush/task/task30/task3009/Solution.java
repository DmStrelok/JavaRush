package com.javarush.task.task30.task3009;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

/* 
Палиндром?
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getRadix("34"));        //expected output: [3, 27, 13, 15]
        System.out.println(getRadix("123"));        //expected output: [6]
        System.out.println(getRadix("5321"));       //expected output: []
        System.out.println(getRadix("1A"));         //expected output: []
    }

    private static Set<Integer> getRadix(String number) {
        Set<Integer> set = new HashSet<>();
        try {
            BigInteger dig = new BigInteger(number);
            StringBuilder sb;
            for (int i = 2; i <= 36; i++) {
                sb = new StringBuilder(dig.toString(i));
                String ss = sb.toString();
                sb.reverse();
                if (ss.equals(sb.toString())) set.add(i);
            }
        } catch (Exception e) {
        }
        return set;
    }
}