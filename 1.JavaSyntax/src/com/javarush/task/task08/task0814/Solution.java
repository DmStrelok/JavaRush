package com.javarush.task.task08.task0814;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/*
Больше 10? Вы нам не подходите
*/

public class Solution {
    public static HashSet<Integer> createSet() {
        //напишите тут ваш код
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < 20; i++) {
            hs.add(i);
        }
        return hs;
    }

    public static HashSet<Integer> removeAllNumbersMoreThan10(HashSet<Integer> set) {
        //напишите тут ваш код
        ArrayList<Integer> ar = new ArrayList<>();
        for (Integer i : set) {
            if (i > 10) ar.add(i);
        }
        for (int i = 0; i < ar.size(); i++) {
            set.remove(ar.get(i));
        }
        return set;
    }

    public static void main(String[] args) {

    }
}