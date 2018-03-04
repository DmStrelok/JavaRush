package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        switch (args[0]) {
            case "-c": synchronized (allPeople){
                int k = 1;
                for (int i = 1; i < args.length; i++) {
                    if (args[i].equals("м") || args[i].equals("ж")) {
                        creation(args, k, i + 2);
                        k = i + 2;
                    }
                }
                break;
            }
            case "-u": synchronized (allPeople){
                int k = 1;
                for (int i = 1; i < args.length; i++) {
                    if (args[i].equals("м") || args[i].equals("ж")) {
                        updates(args, k, i + 2);
                        k = i + 2;
                    }
                }
                break;
            }
            case "-d": synchronized (allPeople){
                for (int i = 1; i < args.length; i++) {
                    deletion(Integer.parseInt(args[i]));
                }
                break;
            }
            case "-i": synchronized (allPeople){
                for (int i = 1; i < args.length; i++) {
                    info(Integer.parseInt(args[i]));
                }
                break;
            }
        }
    }

    public static void creation(String[] args, int n, int k) {
        String name = args[n];
        for (int i = n + 1; i < k - 2; i++) {
            name = name.concat(" ").concat(args[i]);
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        try {
            if (args[k - 2].equals("м")) allPeople.add(Person.createMale(name, sdf.parse(args[k - 1])));
            else allPeople.add(Person.createFemale(name, sdf.parse(args[k - 1])));
        } catch (ParseException e) {
        }
        System.out.println(allPeople.size() - 1);
    }

    public static void updates(String[] args, int n, int k) {
        String name = args[n + 1];
        for (int i = n + 2; i < k - 2; i++) {
            name = name.concat(" ").concat(args[i]);
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        try {
            if (args[k - 2].equals("м")) allPeople.set(Integer.parseInt(args[n]), Person.createMale(name, sdf.parse(args[k - 1])));
            else allPeople.set(Integer.parseInt(args[n]), Person.createFemale(name, sdf.parse(args[k - 1])));
        } catch (ParseException e) {
        }
    }

    public static void deletion(int i) {
        Person p = allPeople.get(i);
        p.setSex(null);
        p.setName(null);
        p.setBirthDay(null);
        allPeople.set(i, p);
    }

    public static void info(int i) {
        Person p = allPeople.get(i);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        System.out.println(p.getName() + " " + (p.getSex().equals(Sex.MALE) ? "м" : "ж") + " " + sdf.format(p.getBirthDay()));
    }
}
