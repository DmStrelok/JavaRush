package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) {
        if (args.length > 0) {
            try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
                while (br.ready()) {
                    String[] s = br.readLine().split(" ");
                    SimpleDateFormat sdf = new SimpleDateFormat("d M yyyy");
                    String d = s[s.length - 3].concat(" ").concat(s[s.length - 2]).concat(" ").concat(s[s.length - 1]);
                    String name = s[0];
                    for (int i = 1; i < s.length - 3; i++) {
                        name = name.concat(" ").concat(s[i]);
                    }
                    PEOPLE.add(new Person(name, sdf.parse(d)));
                }
            }
            catch (IOException e) {}
            catch (ParseException e) {}
        }
    }
}
