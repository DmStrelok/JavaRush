package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestOrder extends Order {
    public TestOrder(Tablet tablet) throws IOException {
        super(tablet);
        initDishes();
    }

    protected void initDishes() {
        List<Dish> list = new ArrayList<>();
        int n = (int) (Math.random() * 5) + 1;
        for (int i = 0; i < n; i++) {
            int d = (int) (Math.random() * Dish.values().length);
            list.add(Dish.values()[d]);
        }
        dishes = list;
    }
}
