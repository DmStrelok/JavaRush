package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Helper;
import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.HashBiMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class SpeedTest {
    public long getTimeForGettingIds(Shortener shortener, Set<String> strings, Set<Long> ids) {
        Date nd = new Date();
        for (String s : strings) {
            ids.add(shortener.getId(s));
        }
        Date kd = new Date();
        return kd.getTime() - nd.getTime();
    }

    public long getTimeForGettingStrings(Shortener shortener, Set<Long> ids, Set<String> strings) {
        Date nd = new Date();
        for (Long id : ids) {
            strings.add(shortener.getString(id));
        }
        Date kd = new Date();
        return kd.getTime() - nd.getTime();
    }

    @Test
    public void testHashMapStorage() {
        Shortener shortener1 = new Shortener(new HashMapStorageStrategy());
        Shortener shortener2 = new Shortener(new HashBiMapStorageStrategy());
        Set<String> origStrings = new HashSet<>();
        for (int i = 0; i < 10000; i++) {
            origStrings.add(Helper.generateRandomString());
        }

        Set<Long> ids1 = new HashSet<>();
        Long td1 = getTimeForGettingIds(shortener1, origStrings, ids1);
        Set<Long> ids2 = new HashSet<>();
        Long td2 = getTimeForGettingIds(shortener2, origStrings, ids2);
        Assert.assertTrue(td1 > td2);

        Set<String> strings1 = new HashSet<>();
        td1 = getTimeForGettingStrings(shortener1, ids1, strings1);
        Set<String> strings2 = new HashSet<>();
        td2 = getTimeForGettingStrings(shortener2, ids2, strings2);
        Assert.assertEquals(td1, td2, 30);

    }
}
