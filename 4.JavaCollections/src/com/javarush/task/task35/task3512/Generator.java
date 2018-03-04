package com.javarush.task.task35.task3512;

public class Generator<T> {
    Class<T> claz;

    public Generator(Class<T> eventClass) {
        claz = eventClass;
    }

    T newInstance() throws IllegalAccessException, InstantiationException {
        return claz.newInstance();
    }
}
