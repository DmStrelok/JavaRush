package com.javarush.task.task06.task0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Родственные связи кошек
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Cat cD = new Cat(reader.readLine());
        Cat cB = new Cat(reader.readLine());
        Cat cF = new Cat(reader.readLine(),null, cD);

        String motherName = reader.readLine();
        Cat catMother = new Cat(motherName, cB, null);

        Cat cS = new Cat(reader.readLine(), catMother, cF);

        String daughterName = reader.readLine();
        Cat catDaughter = new Cat(daughterName, catMother, cF);

        System.out.println(cD);
        System.out.println(cB);
        System.out.println(cF);
        System.out.println(catMother);
        System.out.println(cS);
        System.out.println(catDaughter);
    }

    public static class Cat {
        private String name;
        private Cat mother;
        private Cat father;

        Cat(String name) {
            this.name = name;
        }

        Cat(String name, Cat mother, Cat father) {
            this.name = name;
            this.mother = mother;
            this.father = father;
        }

        @Override
        public String toString() {
            if (mother == null && father == null)
                return "Cat name is " + name + ", no mother, no father";
            if (mother == null)
                return "Cat name is " + name + ", no mother, father is " + father.name;
            if (father == null)
                return "Cat name is " + name + ", mother is " + mother.name + ", no father";
            else return "Cat name is " + name + ", mother is " + mother.name + ", father is " + father.name;

        }
    }

}
