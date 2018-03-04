package com.javarush.task.task34.task3403;

/*
Разложение на множители с помощью рекурсии
*/
public class Solution {
    public void recursion(int n) {
        int k = 2;
        while (n > 1) {
            if (n % k == 0) {
                System.out.print(k + " ");
                recursion(n /= k);
                return;
            }
            k++;
        }
        /*
        int k = 2;
        while (n > 1) {
            if (n % k == 0) {
                System.out.print(list.get(i) + " ");
                n /= k;
                continue;
            }
            k++;
        }
        */
    }
}
