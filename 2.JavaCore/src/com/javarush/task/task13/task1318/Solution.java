package com.javarush.task.task13.task1318;

import java.io.*;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        InputStream fi = new FileInputStream(bf.readLine());
        while (fi.available() > 0) {
            System.out.print((char) fi.read());
        }
        System.out.println();
        fi.close();
        bf.close();
    }
}