package com.javarush.task.task39.task3909;

/* 
Одно изменение
*/
public class Solution {
    public static void main(String[] args) {
    }

    public static boolean isOneEditAway(String first, String second) {
        if (first == null || second == null) return false;
        if (first.equals("") && second.length() < 2) return true;
        if (second.equals("") && first.length() < 2) return true;
        if (second.equals("") || first.equals("")) return false;
        if (Math.abs(first.length() - second.length()) > 1) return false;

        if (first.length() < second.length()) {
            if (first.equals(second.substring(1)) || first.equals(second.substring(0, second.length() - 1))) return true;
            for (int i = 1; i < first.length() - 1; i++) {
                if (first.substring(0, i).equals(second.substring(0, i))
                        && first.substring(i).equals(second.substring(i + 1))) return true;
            }
            return false;
        }
        if (second.length() < first.length()) {
            if (second.equals(first.substring(1)) || second.equals(first.substring(0, first.length() - 1))) return true;
            for (int i = 1; i < second.length() - 1; i++) {
                if (second.substring(0, i).equals(first.substring(0, i))
                        && second.substring(i).equals(first.substring(i + 1))) return true;
            }
            return false;
        }

        if (first.substring(1).equals(second.substring(1))
                || first.substring(0, first.length() - 1).equals(second.substring(0, second.length() - 1))) return true;
        for (int i = 1; i < first.length() - 1; i++) {
            if (first.substring(0, i).equals(second.substring(0, i))
                    && first.substring(i + 1).equals(second.substring(i + 1))) return true;
        }
        return false;
    }
}
