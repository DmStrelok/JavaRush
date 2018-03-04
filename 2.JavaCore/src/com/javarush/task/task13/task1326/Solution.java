package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader brf = null;

        ArrayList<Integer> aa = new ArrayList<>();

        try {
            brf = new BufferedReader(new InputStreamReader(new FileInputStream(br.readLine())));
        for (; brf.ready(); ) {
            int a = Integer.parseInt(brf.readLine());
            if (a % 2 == 0) aa.add(a);
        }
        for (int i = 0; i < aa.size(); i++) {
            int k = i;
            for (int j = i; j < aa.size(); j++) {
                if (aa.get(k) > aa.get(j)) k = j;
            }
            if (k != i) { int v = aa.get(i); aa.set(i, aa.get(k)); aa.set(k, v); }
        }
        for (int i = 0; i < aa.size(); i++) {
            System.out.println(aa.get(i));
        }
            br.close();
            brf.close();
        }
        catch (Exception e) {
            br.close();
            brf.close();
        }
    }
}
