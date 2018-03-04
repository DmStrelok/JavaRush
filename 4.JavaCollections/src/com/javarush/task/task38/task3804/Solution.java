package com.javarush.task.task38.task3804;

/* 
Фабрика исключений
*/

public class Solution {
    public static Class getFactoryClass() {
        return ExFactory.class;
    }

    public static void main(String[] args) {
        System.out.println(ExFactory.exFactory(ExceptionApplicationMessage.SOCKET_IS_CLOSED).getMessage());
    }
}