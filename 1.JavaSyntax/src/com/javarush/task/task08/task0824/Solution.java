package com.javarush.task.task08.task0824;

/* 
Собираем семейство
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Human b1 = new Human("B1", 80, false);
        Human b2 = new Human("B2", 80, false);
        Human d1 = new Human("D1", 80, true);
        Human d2 = new Human("D2", 80, true);
        Human f = new Human("F", 50, true);
        Human m = new Human("M", 45, false);
        Human c1 = new Human("C1", 13, false);
        Human c2 = new Human("C2", 15, true);
        Human c3 = new Human("C3", 11, true);
        b1.children.add(f);
        d1.children.add(f);
        b2.children.add(m);
        d2.children.add(m);
        f.children.add(c1);
        f.children.add(c2);
        f.children.add(c3);
        m.children.add(c1);
        m.children.add(c2);
        m.children.add(c3);
        System.out.println(b1);
        System.out.println(d1);
        System.out.println(b2);
        System.out.println(d2);
        System.out.println(f);
        System.out.println(m);
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
    }

    public static class Human {
        //напишите тут ваш код
        String name;
        int age;
        boolean sex;
        ArrayList<Human> children = new ArrayList<>();

        public Human(String name, int age, boolean sex) {
            this.name = name;
            this.age = age;
            this.sex = sex;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }

}
