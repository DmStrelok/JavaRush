package com.javarush.task.task08.task0801;

/* 
HashSet из растений
*/

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        HashSet<String> s = new HashSet<>();
        s.add("арбуз");
        s.add("банан");
        s.add("вишня");
        s.add("груша");
        s.add("дыня");
        s.add("ежевика");
        s.add("жень-шень");
        s.add("земляника");
        s.add("ирис");
        s.add("картофель");
        for (String i : s) {
            System.out.println(i);
        }
    }
}
