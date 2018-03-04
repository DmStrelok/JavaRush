package com.javarush.task.task05.task0526;

/* 
Мужчина и женщина
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Man man = new Man("dfd", 33, "dfs df sdfs");
        Man man2 = new Man("dfd", 33, "dfs df sdfs");
        Woman woman = new Woman("rrr", 24, "sdfsdf sdfsdf d");
        Woman woman2 = new Woman("rrr", 24, "sdfsdf sdfsdf d");
        System.out.println(man.name + " " + man.age + " " + man.address);
        System.out.println(man2.name + " " + man2.age + " " + man2.address);
        System.out.println(woman.name + " " + woman.age + " " + woman.address);
        System.out.println(woman2.name + " " + woman2.age + " " + woman2.address);
    }

    public static class Man {
        String name;
        int age;
        String address;

        public Man(String name, int age, String address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }
    }
    public static class Woman {
        String name;
        int age;
        String address;

        public Woman(String name, int age, String address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }
    }

    //напишите тут ваш код
}
