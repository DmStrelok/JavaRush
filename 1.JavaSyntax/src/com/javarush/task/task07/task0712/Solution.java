package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> s = new ArrayList<String>();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        s.add(bf.readLine());
        int mx = s.get(0).length(), mn = s.get(0).length();
        int imx = 0, imn = 0;
        for (int i = 1; i < 10; i++) {
            s.add(bf.readLine());
            if (s.get(i).length() > mx) {
                mx = s.get(i).length();
                imx = i;
            }
            else if (s.get(i).length() < mn) {
                mn = s.get(i).length();
                imn = i;
            }
        }
        if (imx < imn) System.out.println(s.get(imx));
        else System.out.println(s.get(imn));
    }
}
