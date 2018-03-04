package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {
    }

    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            String s = fileScanner.nextLine();
            Date d = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
            try {
                d = sdf.parse(s.split(" ")[3].concat(s.split(" ")[4]).concat(s.split(" ")[5]));
            } catch (ParseException e) {
            }
            return new Person(s.split(" ")[1], s.split(" ")[2], s.split(" ")[0], d);
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
