package com.javarush.task.task27.task2712.kitchen;

public enum Dish {
    Fish(25),
    Steak(30),
    Soup(15),
    Juice(5),
    Water(3);

    private int duration;

    Dish(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public static String allDishesToString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < Dish.values().length - 1; i++) {
            s.append(Dish.values()[i]).append(", ");
        }
        s.append(Dish.values()[Dish.values().length - 1]);
        return s.toString();
    }
}
