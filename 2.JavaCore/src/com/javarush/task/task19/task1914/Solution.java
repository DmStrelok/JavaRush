package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream ps = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream pso = new PrintStream(baos);
        System.setOut(pso);
        testString.printSomething();
        String s = baos.toString();
        int a = Integer.parseInt(s.substring(0, s.indexOf(" ")));
        int b = Integer.parseInt(s.substring(s.indexOf(" ") + 3, s.indexOf("=") - 1));
        int c;
        if (s.indexOf("+") != -1) c = a + b;
        else if (s.indexOf("-") != -1) c = a - b;
        else c = a * b;
        System.setOut(ps);
        System.out.println(s + c);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

