package com.javarush.task.task08.task0817;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Нам повторы не нужны
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

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map) {
        //напишите тут ваш код
        ArrayList<String> ar = new ArrayList<>();
        for (String i : map.values()) {
            int k = 0;
            for (String j : map.values()) {
                if (j.equals(i)) k++;
            }
            if (k > 1) ar.add(i);
        }
        for (int i = 0; i < ar.size(); i++) {
            removeItemFromMapByValue(map, ar.get(i));
        }
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {

    }
}
