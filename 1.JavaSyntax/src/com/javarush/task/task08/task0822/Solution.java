package com.javarush.task.task08.task0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* 
Минимальное из N чисел
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        List<Integer> integerList = getIntegerList();
        System.out.println(getMinimum(integerList));
    }

    public static int getMinimum(List<Integer> array) {
        // find minimum here — найти минимум тут
        int m = array.get(0);
        for (int i = 1; i < array.size(); i++) {
            if (m > array.get(i)) m = array.get(i);
        }
        return m;
    }

    public static List<Integer> getIntegerList() throws IOException {
        //create and initialize a list here - создать и заполнить список тут
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> l = new ArrayList<>();
        int n = Integer.parseInt(bf.readLine());
        for (int i = 0; i < n; i++) {
            l.add(Integer.parseInt(bf.readLine()));
        }
        return l;
    }
}
