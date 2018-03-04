package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* 
Перепись населения
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        //напишите тут ваш код
        HashMap<String, String> hm = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            hm.put("f" + i, "n" + i);
        }
        return hm;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
        //напишите тут ваш код
        int k = 0;
        for (String i : map.values()) {
            if (name.equals(i)) k++;
        }
        return k;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {
        //напишите тут ваш код
        int k = 0;
        for (String i : map.keySet()) {
            if (lastName.equals(i)) k++;
        }
        return k;
    }

    public static void main(String[] args) {

    }
}
