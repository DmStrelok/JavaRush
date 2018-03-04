package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        testStrategy(new HashMapStorageStrategy(), 5000);
        testStrategy(new OurHashMapStorageStrategy(), 5000);
        testStrategy(new OurHashBiMapStorageStrategy(), 5000);
        testStrategy(new HashBiMapStorageStrategy(), 5000);
        testStrategy(new DualHashBidiMapStorageStrategy(), 5000);
        testStrategy(new FileStorageStrategy(), 50);
    }

    public static Set<Long> getIds(Shortener shortener, Set<String> strings) {
        Set<Long> set = new HashSet<>();
        for (String s : strings) {
            set.add(shortener.getId(s));
        }
        return set;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys) {
        Set<String> set = new HashSet<>();
        for (Long k : keys) {
            set.add(shortener.getString(k));
        }
        return set;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber) {
        Helper.printMessage(strategy.getClass().getSimpleName());
        Set<String> strings = new HashSet<>();
        for (int i = 0; i < elementsNumber; i++) {
            strings.add(Helper.generateRandomString());
        }
        Shortener shortener = new Shortener(strategy);

        Date nd = new Date();
        Set<Long> ids = getIds(shortener, strings);
        Date kd = new Date();
        Helper.printMessage(String.valueOf(kd.getTime() - nd.getTime()));

        Date nds = new Date();
        Set<String> strs = getStrings(shortener, ids);
        Date kds = new Date();
        Helper.printMessage(String.valueOf(kds.getTime() - nds.getTime()));

        //strs.add("ff");
        //strs.remove(strings.iterator().next());
        //strings.remove(strings.iterator().next());
        boolean f = false;
        if (strs.size() == strings.size()) {
            long i = 0;
            for (String s :strs) {
                if (!strings.contains(s)) break;
                else i++;
            }
            if (i == strings.size()) f = true;
        }
        if (f) Helper.printMessage("Тест пройден.");
        else Helper.printMessage("Тест не пройден.");
    }
}
