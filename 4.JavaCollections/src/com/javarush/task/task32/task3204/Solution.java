package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        String s = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.write(s.charAt((int) (Math.random() * (s.length() - 36))));
        baos.write(s.charAt((int) (Math.random() * (s.length() - 36) + 26)));
        baos.write(s.charAt((int) (Math.random() * (s.length() - 52) + 52)));
        for (int i = 0; i < 5; i++) {
            baos.write(s.charAt((int) (Math.random() * s.length())));
        }
        return baos;
    }
}