package com.javarush.task.task08.task0802;

/* 
HashMap из 10 пар
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        HashMap<String, String> hs = new HashMap<>();
        hs.put("арбуз", "ягода");
        hs.put("банан", "трава");
        hs.put("вишня", "ягода");
        hs.put("груша", "фрукт");
        hs.put("дыня", "овощ");
        hs.put("ежевика", "куст");
        hs.put("жень-шень", "корень");
        hs.put("земляника", "ягода");
        hs.put("ирис", "цветок");
        hs.put("картофель", "клубень");
        for (Map.Entry<String, String> i: hs.entrySet()) {
            System.out.println(i.getKey() + " - " + i.getValue());
        }
    }
}
