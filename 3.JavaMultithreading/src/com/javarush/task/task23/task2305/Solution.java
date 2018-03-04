package com.javarush.task.task23.task2305;

/* 
Inner
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution[] s = new Solution[2];
        s[0] = new Solution();
        s[1] = new Solution();
        s[0].innerClasses = new InnerClass[]{new Solution().new InnerClass(), new Solution().new InnerClass()};
        s[1].innerClasses = new InnerClass[]{new Solution().new InnerClass(), new Solution().new InnerClass()};
        return s;
    }

    public static void main(String[] args) {

    }
}
