package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;

public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        initDishes();
    }

    public Tablet getTablet() {
        return tablet;
    }

    @Override
    public String toString() {
        if (dishes.size() == 0) return "";
        return "Your order: " + dishes.toString() + " of " + tablet.toString();
    }

    public int getTotalCookingTime() {
        int time = 0;
        for (int i = 0; i < dishes.size(); i++) {
            time += dishes.get(i).getDuration();
        }
        return time;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public boolean isEmpty() {
        return dishes.size() == 0;
    }

    protected void initDishes() throws IOException {
        dishes = ConsoleHelper.getAllDishesForOrder();
    }
}
