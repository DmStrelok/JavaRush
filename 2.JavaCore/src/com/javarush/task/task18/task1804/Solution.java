package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(bf.readLine());
        HashMap<Integer, Integer> hm = new HashMap<>();
        while (fis.available() > 0) {
            int n = fis.read();
            if (!hm.containsKey(n)) hm.put(n, 0);
            hm.put(n, hm.get(n) + 1);
        }
        int m = 0;
        if (hm.keySet().toArray().length > 0) {
            m = hm.get(hm.keySet().toArray()[0]);
            for (Integer i : hm.values()) {
                if (i.compareTo(m) == -1) m = i;
            }
            for (Map.Entry p : hm.entrySet()) {
                if (p.getValue().equals(m)) System.out.print(p.getKey() + " ");
            }
            System.out.println();
        }
        fis.close();
        bf.close();
    }
}
