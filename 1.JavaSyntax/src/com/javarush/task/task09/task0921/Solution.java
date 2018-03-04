package com.javarush.task.task09.task0921;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Метод в try..catch
*/

public class Solution {
    public static void main(String[] args) {
        readData();
    }

    public static void readData() {
        //напишите тут ваш код
        ArrayList<Integer> a = new ArrayList<>();
        try {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            for (;true;) {
                a.add(Integer.parseInt(bf.readLine()));
            }
        }
        catch (Exception e) {
            for (int i : a) {
                System.out.println(i);
            }
        }
    }
}
