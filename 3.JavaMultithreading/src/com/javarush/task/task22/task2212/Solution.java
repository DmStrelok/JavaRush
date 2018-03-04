package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber != null && telNumber.matches("(\\+\\d{2}\\(\\d{3}\\)\\d{3}-?\\d\\d-?\\d\\d)|(\\+\\d{8}-?\\d\\d-?\\d\\d)|(\\d{6}-?\\d\\d-?\\d\\d)|(\\(\\d{3}\\)\\d{3}-?\\d\\d-?\\d\\d)")) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        /*String s;
        s = "+380501234567";
        System.out.println(s + " " + checkTelNumber(s));
        s = "+38(050)1234567";
        System.out.println(s + " " + checkTelNumber(s));
        s = "+38050123-45-67";
        System.out.println(s + " " + checkTelNumber(s));
        s = "050123-4567";
        System.out.println(s + " " + checkTelNumber(s));
        s = "+38)050(1234567";
        System.out.println(s + " " + checkTelNumber(s));
        s = "+38(050)1-23-45-6-7";
        System.out.println(s + " " + checkTelNumber(s));
        s = "050ххх4567";
        System.out.println(s + " " + checkTelNumber(s));
        s = "050123456";
        System.out.println(s + " " + checkTelNumber(s));
        s = "(0)501234567";
        System.out.println(s + " " + checkTelNumber(s));
        s = "22+380501234567";
        System.out.println(s + " " + checkTelNumber(s));
        s = "+38050123456722";
        System.out.println(s + " " + checkTelNumber(s));*/
    }
}
