package com.javarush.task.task08.task0820;

import java.util.HashSet;
import java.util.Set;

/* 
Множество всех животных
*/

public class Solution {
    public static void main(String[] args) {
        Set<Cat> cats = createCats();
        Set<Dog> dogs = createDogs();

        Set<Object> pets = join(cats, dogs);
        printPets(pets);

        removeCats(pets, cats);
        printPets(pets);
    }

    public static Set<Cat> createCats() {
        HashSet<Cat> result = new HashSet<Cat>();

        result.add(new Cat());
        result.add(new Cat());
        result.add(new Cat());
        result.add(new Cat());
        //напишите тут ваш код

        return result;
    }

    public static Set<Dog> createDogs() {
        //напишите тут ваш код
        Set<Dog> d = new HashSet<>();
        d.add(new Dog());
        d.add(new Dog());
        d.add(new Dog());
        return d;
    }

    public static Set<Object> join(Set<Cat> cats, Set<Dog> dogs) {
        //напишите тут ваш код
        Set<Object> p = new HashSet<>();
        for (Cat c : cats) {
            p.add(c);
        }
        for (Dog d : dogs) {
            p.add(d);
        }
        return p;
    }

    public static void removeCats(Set<Object> pets, Set<Cat> cats) {
        //напишите тут ваш код
        for (Cat c : cats) {
            pets.remove(c);
        }
    }

    public static void printPets(Set<Object> pets) {
        //напишите тут ваш код
        for (Object o : pets) {
            System.out.println(o);
        }
    }

    public static class Cat {}
    public static class Dog {}
    //напишите тут ваш код
}
