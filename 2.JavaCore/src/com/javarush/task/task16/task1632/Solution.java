package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new c1());
        threads.add(new c2());
        threads.add(new c3());
        threads.add(new c4());
        threads.add(new c5());
    }

    public static void main(String[] args) {
    }

    static class c1 extends Thread {
        @Override
        public void run() {
            while (true) {}
        }
    }

    static class c2 extends Thread {
        @Override
        public void run() {
            while (!isInterrupted()) {}
            System.out.println("InterruptedException");
        }
    }

    static class c3 extends Thread {
        @Override
        public void run() {
            while (true) {
                System.out.println("Ура");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
            }
        }
    }

    static class c4 extends Thread implements Message {
        boolean k = true;
        @Override
        public void showWarning() {
            k = false;
        }

        @Override
        public void run() {
            while (k) { }
        }
    }

    static class c5 extends Thread {
        @Override
        public void run() {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            int sum = 0;
            try {
                for (String s = bf.readLine(); !s.equals("N"); s = bf.readLine()) {
                    sum += Integer.parseInt(s);
                }
            }
            catch (IOException e) {}
            System.out.println(sum);
        }
    }
}