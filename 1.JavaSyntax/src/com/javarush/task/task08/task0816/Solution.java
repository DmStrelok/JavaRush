package com.javarush.task.task08.task0816;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static HashMap<String, Date> createMap() {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", new Date("JUNE 1 1980"));
        for (int i = 0; i < 9; i++) {
            map.put("f" + i, new Date("MAY 4 198" + i));
        }
        //напишите тут ваш код
        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {
        //напишите тут ваш код
        Iterator<HashMap.Entry<String, Date>> i = map.entrySet().iterator();
        for (;i.hasNext();) {
            Date d = i.next().getValue();
            if (d.getMonth() == 5 || d.getMonth() == 6 || d.getMonth() == 7) i.remove();
        }
    }

    public static void main(String[] args) {

    }
}
