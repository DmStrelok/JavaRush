package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> in = new ArrayList<>();
        int m = 1, n = 1;
        in.add(Integer.parseInt(bf.readLine()));
        for (int i = 1; i < 10; i++) {
            in.add(Integer.parseInt(bf.readLine()));
            if (in.get(i) == in.get(i - 1)) n++;
            else {
                if (n > m) m = n;
                n = 1;
            }
        }
        if (n > m) m = n;
        System.out.println(m);

    }
}