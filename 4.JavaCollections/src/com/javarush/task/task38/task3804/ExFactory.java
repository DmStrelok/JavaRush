package com.javarush.task.task38.task3804;

public class ExFactory {
    public static Throwable exFactory(Enum e) {
        if (e == null) return new IllegalArgumentException();
        String s = e.toString().replaceAll("_", " ").toLowerCase();
        if (e instanceof ExceptionApplicationMessage) {
            return new Exception(s.substring(0, 1).toUpperCase() + s.substring(1));
        } else
            if (e instanceof ExceptionDBMessage) {
                return new RuntimeException(s.substring(0, 1).toUpperCase() + s.substring(1));
            } else
                if (e instanceof ExceptionUserMessage) {
                    return new Error(s.substring(0, 1).toUpperCase() + s.substring(1));
                }
        return new IllegalArgumentException();
    }
}
