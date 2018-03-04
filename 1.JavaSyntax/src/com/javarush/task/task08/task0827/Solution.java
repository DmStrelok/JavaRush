package com.javarush.task.task08.task0827;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(isDateOdd("MAY 1 2013"));
    }

    public static boolean isDateOdd(String date) {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("MMMM dd yyyy", Locale.ENGLISH);
        Date d = new Date();
        try {
            d = format.parse(date);
        } catch (ParseException e) {

        }
        c.setTime(d);
        return c.get(Calendar.DAY_OF_YEAR) % 2 != 0 ? true : false;
    }
}
