package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String s = "";
            try (FileInputStream fis = new FileInputStream(s = br.readLine())) {

            }
            catch (FileNotFoundException e) {
                System.out.println(s);
                break;
            }
            catch (IOException e) {}
        }
    }
}
