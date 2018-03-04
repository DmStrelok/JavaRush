package com.javarush.task.task14.task1414;

/* 
MovieFactory
*/

import jdk.internal.dynalink.beans.StaticClass;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        //ввести с консоли несколько ключей (строк), пункт 7
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Movie> movie = new ArrayList<>();
        String s = br.readLine();
        for (; s.equals("cartoon") || s.equals("thriller") || s.equals("soapOpera"); s = br.readLine()) {
            movie.add(MovieFactory.getMovie(s));
        }
        movie.add(MovieFactory.getMovie(s));
        movie.remove(movie.size()-1);
        for (int i = 0; i < movie.size(); i++) {
            System.out.println(movie.get(i).getClass().getSimpleName());
        }

        /*
8 Создать переменную movie класса Movie и для каждой введенной строки(ключа):
8.1 получить объект используя MovieFactory.getMovie и присвоить его переменной movie
8.2 вывести на экран movie.getClass().getSimpleName()
        */

    }

    static class MovieFactory {

        static Movie getMovie(String key) {
            Movie movie = null;

            //создание объекта SoapOpera (мыльная опера) для ключа "soapOpera"
            if ("soapOpera".equals(key)) {
                movie = new SoapOpera();
            }
            if ("cartoon".equals(key)) {
                movie = new Cartoon();
            }
            if ("thriller".equals(key)) {
                movie = new Thriller();
            }
            //напишите тут ваш код, пункты 5,6

            return movie;
        }
    }

    static abstract class Movie {
    }

    static class SoapOpera extends Movie {
    }
    static class Cartoon extends Movie {}

    static class Thriller extends Movie {}

    //Напишите тут ваши классы, пункт 3
}
