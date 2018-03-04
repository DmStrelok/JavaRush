package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            for (String s = br.readLine(); !s.equals("exit"); s = br.readLine()) {
                new ReadThread(s).start();
            }
        }
        catch (IOException e) {}
    }

    public static class ReadThread extends Thread {
        public ReadThread(String fileName) {
            fb(fileName);
            //implement constructor body
        }
        // implement file reading here - реализуйте чтение из файла тут
        public void fb (String fileName) {
            try (FileInputStream fis = new FileInputStream(fileName)) {
                Map<Integer, Integer> hm = new HashMap<>();
                while (fis.available() > 0) {
                    int n = fis.read();
                    if (!hm.containsKey(n)) hm.put(n, 0);
                    hm.put(n, hm.get(n) + 1);
                }
                int m = hm.values().stream().max(Integer::compareTo).get();
                hm.entrySet().stream().forEach(e -> {
                        if (e.getValue() == m) {
                            synchronized (resultMap) {
                                resultMap.put(fileName, e.getKey());
                            }
                        }
                    });
            }
            catch (IOException e) {}
        }
    }
}
