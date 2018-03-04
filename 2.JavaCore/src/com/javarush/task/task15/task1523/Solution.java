package com.javarush.task.task15.task1523;

/* 
Перегрузка конструкторов
*/

public class Solution {
    public static void main(String[] args) {

    }

    private Solution(int a) {}
    protected Solution(long b) {}
    public Solution(byte c) {}
    Solution() {}
}

