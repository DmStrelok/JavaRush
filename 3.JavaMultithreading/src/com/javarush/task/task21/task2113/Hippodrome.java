package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses;

    public static Hippodrome game;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public static void main (String[] args) throws InterruptedException {
        List<Horse> h = new ArrayList<>();
        h.add(new Horse("horse1", 3, 0));
        h.add(new Horse("horse2", 3, 0));
        h.add(new Horse("horse3", 3, 0));
        Hippodrome.game = new Hippodrome(h);
        game.run();
        game.printWinner();
    }

    public void move() {
        for (int i = 0; i < horses.size(); i++) {
            horses.get(i).move();
        }
    }

    public void print() {
        for (int i = 0; i < horses.size(); i++) {
            horses.get(i).print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public Horse getWinner() {
        Horse h = horses.get(0);
        for (int i = 1; i < horses.size(); i++) {
            if (h.distance < horses.get(i).distance) h = horses.get(i);
        }
        return h;
    }

    public void printWinner() {
        System.out.println("Winner is ".concat(getWinner().name).concat("!"));
    }
}
