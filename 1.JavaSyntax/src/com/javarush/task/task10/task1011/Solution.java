package com.javarush.task.task10.task1011;

/* 
Большая зарплата
*/

public class Solution {
    public static void main(String[] args) {
        String s = "Я не хочу изучать Java, я хочу большую зарплату";
        for (int i = 0; i < 40; i++) {
            if (s.charAt(0) == ' ') System.out.println(s.substring(1));
            else System.out.println(s);
            s = s.substring(1);
        }
        //напишите тут ваш код
    }

}

