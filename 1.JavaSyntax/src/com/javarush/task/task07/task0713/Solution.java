package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> a = new ArrayList<Integer>();
        ArrayList<Integer> b = new ArrayList<Integer>();
        ArrayList<Integer> c = new ArrayList<Integer>();
        ArrayList<Integer> d = new ArrayList<Integer>();
        for (int i = 0; i < 20; i++) {
            a.add(Integer.parseInt(bf.readLine()));
            if (a.get(i) % 2 != 0 && a.get(i) % 3 != 0) d.add(a.get(i));
            if (a.get(i) % 3 == 0) b.add(a.get(i));
            if (a.get(i) % 2 == 0) c.add(a.get(i));
        }
        printList(b);
        printList(c);
        printList(d);
    }

    public static void printList(List<Integer> list) {
        //напишите тут ваш код
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
