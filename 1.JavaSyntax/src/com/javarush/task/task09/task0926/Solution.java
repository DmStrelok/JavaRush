package com.javarush.task.task09.task0926;

import java.util.ArrayList;

/* 
Список из массивов чисел
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList() {
        //напишите тут ваш код
        ArrayList<int[]> a = new ArrayList<>();
        a.add(new int[5]);
        a.add(new int[2]);
        a.add(new int[4]);
        a.add(new int[7]);
        a.add(new int[0]);

        for (int i = 0; i < a.size(); i++) {
            int[] b = new int[a.get(i).length];
            for (int j = 0; j < b.length; j ++) {
                 b[j] = (int) (Math.random() * 10);
            }
            a.set(i,b);
        }

        return a;
    }

    public static void printList(ArrayList<int[]> list) {
        for (int[] array : list) {
            for (int x : array) {
                System.out.println(x);
            }
        }
    }
}
