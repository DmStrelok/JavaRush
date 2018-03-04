package com.javarush.task.task21.task2104;

import java.util.HashSet;
import java.util.Set;

/* 
Equals and HashCode
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!(o instanceof Solution)) return false;
        Solution solution = (Solution) o;

        if (first != null ? !first.equals(solution.first) : solution.first != null) return false;
        return last != null ? last.equals(solution.last) : solution.last == null;
    }

    @Override
    public int hashCode() {
        return first == null ? 0 : first.hashCode() + last == null ? 0 : last.hashCode();
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        Solution ss = new Solution("Donald", "Duck");
        System.out.println(ss.getClass());
        System.out.println(ss.getClass() == com.javarush.task.task21.task2104.Solution.class);
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));
    }
}
