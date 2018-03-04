package com.javarush.task.task07.task0707;

import java.util.ArrayList;

/* 
Что за список такой?
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> s = new ArrayList<String>();
        s.add("dfdf");
        s.add("dfdf2");
        s.add("dfdf3");
        s.add("dfdf4");
        s.add("dfdf5");
        System.out.println(s.size());
        for (int i = 0; i < 5; i++) {
            System.out.println(s.get(i));
        }
    }
}
