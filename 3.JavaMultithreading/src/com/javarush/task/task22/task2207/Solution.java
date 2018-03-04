package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader bf = new BufferedReader(new FileReader(br.readLine()))) {
            ArrayList<String> l = new ArrayList();
            while (bf.ready()) {
                Collections.addAll(l, bf.readLine().split(" "));
            }

            while (l.size() > 0) {
                for (int i = 1; i < l.size(); i++) {
                    StringBuilder sb = new StringBuilder(l.get(0));
                    sb.reverse();
                    if (sb.toString().equals(l.get(i))) {
                        result.add(new Pair(l.get(0), l.get(i)));
                        l.remove(i);
                        break;
                    }
                }
                l.remove(0);
            }

            for (int i = 0; i < result.size(); i++) {
                System.out.println(result.get(i));
            }
        }
        catch (IOException e) {}
    }

    public static class Pair {
        String first;
        String second;

        public Pair(String first, String second) {
            this.first = first;
            this.second = second;
        }

        public Pair() {
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
