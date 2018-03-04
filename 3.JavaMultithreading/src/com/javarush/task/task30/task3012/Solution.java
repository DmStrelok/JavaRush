package com.javarush.task.task30.task3012;

/* 
Получи заданное число
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createExpression(3020);
    }

    public void createExpression(int number) {
        int[] list = {1, 3, 9, 27, 81, 243, 729, 2187};
        int[] ch = {-1, -1, -1, -1, -1, -1, -1, -1};
        int sum = 0;
        while (true) {
            for (int i = 0; true;) {
                ch[i] += 1;
                if (ch[i] > 1) ch[i++] = -1;
                else break;
            }
            sum = 0;
            for (int i = 0; i < list.length; i++) {
                sum += ch[i] * list[i];
            }
            if (sum == number) break;
        }
        StringBuilder sb = new StringBuilder(number + " =");
        for (int i = 0; i < list.length; i++) {
            if (ch[i] < 0) sb.append(" - ").append(list[i]);
            if (ch[i] > 0) sb.append(" + ").append(list[i]);
        }
        System.out.println(sb.toString());
        //напишите тут ваш код
    }
}