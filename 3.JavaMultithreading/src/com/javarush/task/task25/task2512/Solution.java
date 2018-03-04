package com.javarush.task.task25.task2512;

/* 
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        tho(e);
    }

    void tho (Throwable e) {
        if (e.getCause() != null) tho(e.getCause());
        System.out.println(e.getClass().getName() + ": " + e.getMessage());
    }
    public static void main(String[] args) {
    }
}
