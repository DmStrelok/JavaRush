package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        ArrayList<Human> s = new ArrayList<>();
        s.add(new Human("gf1",true,90));
        s.add(new Human("gf2",true,91));
        s.add(new Human("gm1",false,88));
        s.add(new Human("gm2",false,89));
        s.add(new Human("f", true, 50, s.get(0), s.get(2)));
        s.add(new Human("m", false, 48, s.get(1), s.get(3)));
        s.add(new Human("s1", false, 25, s.get(4), s.get(5)));
        s.add(new Human("s2", false, 20, s.get(4), s.get(5)));
        s.add(new Human("d1", false, 18, s.get(4), s.get(5)));
        for (int i = 0; i < 9; i++) {
            System.out.println(s.get(i).toString());
        }
    }

    public static class Human {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        public Human(String name, boolean sex, int age, Human father, Human mother) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public Human(String name, boolean sex, int age) {

            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }
}






















