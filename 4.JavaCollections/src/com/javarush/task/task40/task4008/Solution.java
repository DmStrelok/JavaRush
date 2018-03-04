package com.javarush.task.task40.task4008;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.WeekFields;
import java.util.Locale;

/* 
Работа с Java 8 DateTime API
*/

public class Solution {
    public static void main(String[] args) {
        printDate("9.10.2017 5:56:45");
        System.out.println();
        printDate("21.4.2014");
        System.out.println();
        printDate("17:33:40");
    }

    public static void printDate(String date) {
        //напишите тут ваш код
        String dat = "d.M.yyyy";
        String time24 = "H:m:s";
        String[] s = date.split(" ");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(dat);

        try {
            LocalDate localDate = LocalDate.parse(s[0], dateTimeFormatter);

            System.out.println(String.format("День: %d%n" +
                            "День недели: %d%n" +
                            "День месяца: %d%n" +
                            "День года: %d%n" +
                            "Неделя месяца: %d%n" +
                            "Неделя года: %d%n" +
                            "Месяц: %d%n" +
                            "Год: %d",
                    localDate.getDayOfMonth(), localDate.getDayOfWeek().ordinal() + 1,
                    localDate.getDayOfMonth(), localDate.getDayOfYear(),
                    localDate.get(WeekFields.of(Locale.getDefault()).weekOfMonth()),
                    localDate.get(WeekFields.of(Locale.getDefault()).weekOfYear()),
                    localDate.getMonthValue(), localDate.getYear()));
        } catch (DateTimeParseException e) {
            ttt(time24, s[0]);
        }
        if (s.length > 1) {
            ttt(time24, s[1]);
        }
    }

    public static void ttt(String time24, String source) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(time24);
        try {
            LocalTime localTime = LocalTime.parse(source, dateTimeFormatter);
            System.out.print("AM или PM: ");

            int h = localTime.getHour();
            if (h < 12) System.out.println("AM");
            else System.out.println("PM");

            System.out.println(String.format("Часы: %d%n" +
                            "Часы дня: %d%n" +
                            "Минуты: %d%n" +
                            "Секунды: %d",
                    h % 12, h,
                    localTime.getMinute(), localTime.getSecond()));
        } catch (DateTimeParseException e) {
        }


    }
}
