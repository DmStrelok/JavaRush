package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        if (args[0].equals("-c")) {
            String name = args[1];
            for (int i = 2; i < args.length - 2; i++) {
                name = name.concat(" ").concat(args[i]);
            }
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            try {
                if (args[args.length - 2].equals("м")) allPeople.add(Person.createMale(name, sdf.parse(args[args.length - 1])));
                else allPeople.add(Person.createFemale(name, sdf.parse(args[args.length - 1])));
            } catch (ParseException e) {
            }
            System.out.println(allPeople.size() - 1);
        }

        if (args[0].equals("-u")) {
            String name = args[2];
            for (int i = 3; i < args.length - 2; i++) {
                name = name.concat(" ").concat(args[i]);
            }
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            try {
                if (args[args.length - 2].equals("м")) allPeople.set(Integer.parseInt(args[1]), Person.createMale(name, sdf.parse(args[args.length - 1])));
                else allPeople.set(Integer.parseInt(args[1]), Person.createFemale(name, sdf.parse(args[args.length - 1])));
            } catch (ParseException e) {
            }
        }

        if (args[0].equals("-d")) {
            Person p = allPeople.get(Integer.parseInt(args[1]));
            p.setSex(null);
            p.setName(null);
            p.setBirthDay(null);
            allPeople.set(Integer.parseInt(args[1]), p);
        }

        if (args[0].equals("-i")) {
            Person p = allPeople.get(Integer.parseInt(args[1]));
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            System.out.println(p.getName() + " " + (p.getSex().equals(Sex.MALE) ? "м" : "ж") + " " + sdf.format(p.getBirthDay()));
        }
    }
}
