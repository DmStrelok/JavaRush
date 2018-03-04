package com.javarush.task.task08.task0818;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        //напишите тут ваш код
        HashMap<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            hm.put("f" + i, i * 100);
        }
        return hm;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        //напишите тут ваш код
        ArrayList<Integer> z = new ArrayList<>(map.values());
        for (int i = 0; i < z.size(); i++) {
            if (z.get(i) < 500) map.values().remove(z.get(i));
        }
    }

    public static void main(String[] args) {

    }
}