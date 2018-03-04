package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();
    static {
        labels.put(3.3, "ddd");
        labels.put(2.3, "ddd2");
        labels.put(5.3, "ddd3");
        labels.put(4.3, "ddd5");
        labels.put(1.3, "ddd3");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
