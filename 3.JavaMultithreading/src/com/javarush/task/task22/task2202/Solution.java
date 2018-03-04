package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервисо бучения Java."));
    }

    public static String getPartOfString(String string) {
        if (string == null) throw new TooShortStringException();
        int k;
        k = string.indexOf(' ');
        k = string.indexOf(' ', ++k);
        k = string.indexOf(' ', ++k);
        k = string.indexOf(' ', ++k);
        if (k == -1) throw new TooShortStringException();
        try {
            return string.substring(string.indexOf(' ') + 1, string.indexOf(' ', ++k));
        }
        catch (Exception e) {
            return string.substring(string.indexOf(' ') + 1);
        }
    }

    public static class TooShortStringException extends RuntimeException{

    }
}
