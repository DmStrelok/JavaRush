package com.javarush.task.task26.task2601;

import java.util.Arrays;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {
    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        if (array.length < 2) return array;
        Arrays.sort(array);
        double m;
        if (array.length % 2 == 1) m = array[array.length / 2];
        else m = (array[array.length / 2 - 1] + array[array.length / 2])*1.0 / 2;
        Integer[] ar = new Integer[array.length];
        int k = array.length / 2;
        int k2 = k - 1;
        for (int i = 0; i < array.length; i++) {
            if (k == array.length) { ar[i] = array[k2--]; continue; }
            if (k2 == -1) { ar[i] = array[k++]; continue; }
            if (array[k] - m < m - array[k2]) ar[i] = array[k++];
            else ar[i] = array[k2--];
        }

        return ar;
    }
}
