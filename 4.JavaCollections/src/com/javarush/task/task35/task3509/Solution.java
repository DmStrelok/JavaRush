package com.javarush.task.task35.task3509;

import java.util.*;


/* 
Collections & Generics
*/
public class Solution {

    public static void main(String[] args) {
    }

    public static <T> ArrayList<T> newArrayList(T... elements) {
        //напишите тут ваш код
        ArrayList<T> al = new ArrayList<>();
        if (elements != null)
            al.addAll(Arrays.asList(elements));
        return al;
    }

    public static <T> HashSet<T> newHashSet(T... elements) {
        //напишите тут ваш код
        HashSet<T> hs = new HashSet<>();
        if (elements != null)
            hs.addAll(Arrays.asList(elements));
        return hs;
    }

    public static <K, V> HashMap<K, V> newHashMap(List<? extends K> keys, List<? extends V> values) {
        //напишите тут ваш код
        if (keys.size() != values.size()) throw new IllegalArgumentException();
        HashMap<K, V> hm = new HashMap<>();
        for (int i = 0; i < keys.size(); i++) {
            hm.put(keys.get(i), values.get(i));
        }
        return hm;
    }
}
