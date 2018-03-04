package com.javarush.task.task38.task3812;

/* 
Обработка аннотаций
*/

public class Solution {
    public static void main(String[] args) {
        printFullyQualifiedNames(Solution.class);
        printFullyQualifiedNames(SomeTest.class);

        printValues(Solution.class);
        printValues(SomeTest.class);
    }

    public static boolean printFullyQualifiedNames(Class c) {
        if (c.isAnnotationPresent(PrepareMyTest.class)) {
            PrepareMyTest pmt = (PrepareMyTest) c.getAnnotation(PrepareMyTest.class);
            String[] s = pmt.fullyQualifiedNames();
            for (String ss : s) {
                System.out.println(ss);
            }
            return true;
        }
        return false;
    }

    public static boolean printValues(Class c) {
        if (c.isAnnotationPresent(PrepareMyTest.class)) {
            PrepareMyTest pmt = (PrepareMyTest) c.getAnnotation(PrepareMyTest.class);
            Class[] s = pmt.value();
            for (Class cc : s) {
                System.out.println(cc.getSimpleName());
            }
            return true;
        }
        return false;
    }
}
