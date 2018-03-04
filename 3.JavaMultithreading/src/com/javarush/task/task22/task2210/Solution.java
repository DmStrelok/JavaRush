package com.javarush.task.task22.task2210;

import java.util.ArrayList;
import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {
    }

    public static String [] getTokens(String query, String delimiter) {
        StringTokenizer st = new StringTokenizer(query, delimiter);
        ArrayList<String> al = new ArrayList<>();
        while (st.hasMoreTokens()) {
            al.add(st.nextToken());
        }
        return al.toArray(new String[0]);
    }
}
