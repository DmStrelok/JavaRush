package com.javarush.task.task40.task4009;

import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;

/* 
Buon Compleanno!
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(weekDayOfBirthday("30.05.1984", "2015"));
    }

    public static String weekDayOfBirthday(String birthday, String year) {
        //напишите тут ваш код
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("d.M.yyyy");
        LocalDate localDate = LocalDate.parse(birthday, dateTimeFormatter);
        Year year1 = Year.parse(year);
        LocalDate ld = localDate.with(year1);
        dateTimeFormatter = DateTimeFormatter.ofPattern("EEEE", Locale.ITALIAN);
        return dateTimeFormatter.format(ld);
    }
}
