package com.javarush.task.task36.task3602;

import java.util.*;

/* 
Найти класс по описанию
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() {
        Class clazz = Collections.class;
        Class[] classes = clazz.getDeclaredClasses();
        for (int i = 0; i < classes.length; i++) {
            if (classes[i].getName().equals("java.util.Collections$EmptyList"))
                return classes[i];

        }
        return null;
    }
}
