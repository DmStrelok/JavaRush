package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        private int a, b, c, d;
        private String e, f;

        public Human(int a, int b, int c, int d, String e, String f) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
            this.e = e;
            this.f = f;
        }

        public Human(int b, int c, int d, String e) {

            this.b = b;
            this.c = c;
            this.d = d;
            this.e = e;
        }

        public Human(int c, int d, String e) {

            this.c = c;
            this.d = d;
            this.e = e;
        }

        public Human(int d, String e) {
            this.d = d;
            this.e = e;
        }

        public Human(String e, String f) {

            this.e = e;
            this.f = f;
        }

        public Human(String e) {

            this.e = e;
        }

        public Human(int a, int b, int c, int d) {

            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }

        public Human(int a, int b, int c) {

            this.a = a;
            this.b = b;
            this.c = c;
        }

        public Human(int a, int b) {

            this.a = a;
            this.b = b;
        }

        public Human(int a) {

            this.a = a;
        }
        // напишите тут ваши переменные и конструкторы
    }
}
