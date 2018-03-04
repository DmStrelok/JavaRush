package com.javarush.task.task14.task1419;

import java.lang.instrument.IllegalClassFormatException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //it's first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            float[] a = new float[3];
            System.out.println(a[3]);

        } catch (Exception e) {
            exceptions.add(e);
        }
        exceptions.add(new NoSuchFieldException());
        exceptions.add(new NoSuchMethodException());
        exceptions.add(new NoSuchElementException());
        exceptions.add(new NoSuchAlgorithmException());
        exceptions.add(new NoSuchProviderException());
        exceptions.add(new IllegalClassFormatException());
        exceptions.add(new ArrayStoreException());
        exceptions.add(new InterruptedException());

        //напишите тут ваш код

    }
}
