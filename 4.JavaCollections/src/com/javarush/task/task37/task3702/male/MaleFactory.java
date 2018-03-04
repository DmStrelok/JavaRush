package com.javarush.task.task37.task3702.male;

import com.javarush.task.task37.task3702.AbstractFactory;
import com.javarush.task.task37.task3702.Human;

public class MaleFactory implements AbstractFactory {
    @Override
    public Human getPerson(int age) {
        if (age < KidBoy.MAX_AGE + 1) return new KidBoy();
        else if (age < TeenBoy.MAX_AGE + 1) return new TeenBoy();
        else return new Man();
    }
}
