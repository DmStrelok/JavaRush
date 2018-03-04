package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             FileOutputStream fos = new FileOutputStream(br.readLine())) {
            PrintStream ps = System.out;
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PrintStream pso = new PrintStream(baos);
            System.setOut(pso);
            testString.printSomething();
            fos.write(baos.toByteArray());
            System.setOut(ps);
            System.out.println(baos.toString());
        }
        catch (IOException e) {}
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

