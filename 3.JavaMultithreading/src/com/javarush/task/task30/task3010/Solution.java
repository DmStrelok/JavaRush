package com.javarush.task.task30.task3010;

/* 
Минимальное допустимое основание системы счисления
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        try {
            String numd = "0123456789abcdefghijklmnopqrstuvwxyz";
            String num = "";
            for (int i = 0; i < args.length; i++) {
                num = num.concat(args[i]);
            }
            num = num.toLowerCase();
            for (int i = 0; i < num.length(); i++) {
                if (numd.indexOf(num.charAt(i)) == -1) {
                    System.out.println("incorrect");
                    return;
                }
            }
            int ns = 1;
            for (int i = 0; i < num.length(); i++) {
                if (numd.indexOf(num.charAt(i)) > ns) ns = numd.indexOf(num.charAt(i));
            }
            System.out.println(ns + 1);
        } catch (Exception e) {
        }
    }
}