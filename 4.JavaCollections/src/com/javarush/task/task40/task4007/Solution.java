package com.javarush.task.task40.task4007;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/* 
Работа с датами
*/

public class Solution {
    public static void main(String[] args) {
        printDate("21.4.2014 15:56:45");
        System.out.println();
        printDate("21.4.2014");
        System.out.println();
        printDate("17:33:40");
    }

    public static void printDate(String date) {
        //напишите тут ваш код
        String dat = "dd.MM.yyyy";
        String time24 = "HH:mm:ss";
        String[] s = date.split(" ");
        SimpleDateFormat sdf = new SimpleDateFormat(dat);
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(sdf.parse(s[0]));
            int d = calendar.get(Calendar.DAY_OF_WEEK);
            d--;
            if (d == 0) d = 7;
            System.out.println(String.format("День: %d%n" +
                    "День недели: %d%n" +
                    "День месяца: %d%n" +
                    "День года: %d%n" +
                    "Неделя месяца: %d%n" +
                    "Неделя года: %d%n" +
                    "Месяц: %d%n" +
                    "Год: %d",
                    calendar.get(Calendar.DAY_OF_MONTH), d,
                    calendar.get(Calendar.DAY_OF_MONTH), calendar.get(Calendar.DAY_OF_YEAR),
                    calendar.get(Calendar.WEEK_OF_MONTH), calendar.get(Calendar.WEEK_OF_YEAR),
                    calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.YEAR)));
        } catch (ParseException e) {
            ttt(time24, s[0], calendar);
        }
        if (s.length > 1) {
            ttt(time24, s[1], calendar);
        }
    }

    public static void ttt(String time24, String source, Calendar calendar) {
        SimpleDateFormat sdf;
        try {
            sdf = new SimpleDateFormat(time24);
            calendar.setTime(sdf.parse(source));
            System.out.print("AM или PM: ");
            if (calendar.get(Calendar.AM_PM) == 0) System.out.println("AM");
            else System.out.println("PM");
        } catch (ParseException ignored) {
        }
        System.out.println(String.format("Часы: %d%n" +
                        "Часы дня: %d%n" +
                        "Минуты: %d%n" +
                        "Секунды: %d",
                calendar.get(Calendar.HOUR), calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE), calendar.get(Calendar.SECOND)));
    }
}
