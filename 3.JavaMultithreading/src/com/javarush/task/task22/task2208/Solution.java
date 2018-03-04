package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
        Map<String, String> m = new HashMap<>();
        m.put("name", "Ivanov");
        m.put("country", null);
        m.put("city", null);
        m.put("age", null);
        System.out.println(getQuery(m));
    }
    public static String getQuery(Map<String, String> params) {
        StringBuilder sb = new StringBuilder("");
        for (Map.Entry<String, String> p : params.entrySet()) {
            if (p.getValue() != null) {
                sb.append(" and ").append(p.getKey()).append(" = '").append(p.getValue()).append("'");
            }
        }
        sb.delete(0,5);
        return sb.toString();
    }
}
