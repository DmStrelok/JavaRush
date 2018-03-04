package com.javarush.task.task10.task1015;

import java.util.ArrayList;

/* 
Массив списков строк
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList() {
        //напишите тут ваш код
        ArrayList<String>[] s = new ArrayList[3];
        s[0] = new ArrayList<>();
        s[0].add("wsdff");
        s[1] = new ArrayList<>();
        s[1].add("wsdeff");
        s[2] = new ArrayList<>();
        s[2].add("33wsdff");
        s[2].add("3d3wsdff");
        return s;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}