package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.util.*;

public class StatisticManager {
    private static StatisticManager ourInstance = new StatisticManager();
    private StatisticStorage statisticStorage = new StatisticStorage();

    public static StatisticManager getInstance() {
        return ourInstance;
    }

    private StatisticManager() {
    }

    public void register(EventDataRow data) {
        statisticStorage.put(data);
    }

    private static class StatisticStorage {
        private Map<EventType, List<EventDataRow>> storage = new HashMap<>();

        private StatisticStorage() {
            for (int i = 0; i < EventType.values().length; i++) {
                storage.put(EventType.values()[i], new ArrayList<EventDataRow>());
            }
        }

        private void put(EventDataRow data) {
            storage.get(data.getType()).add(data);
        }

        private List<EventDataRow> getEventList(EventType eventType) {
            return storage.get(eventType);
        }
    }

    public Map<Long, Long> getVideo() {
        List<EventDataRow> list = statisticStorage.getEventList(EventType.SELECTED_VIDEOS);
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(list.get(i).getDate());
            calendar.set(Calendar.HOUR, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);
            long date = calendar.getTimeInMillis();
            if (!map.containsKey(date))
                map.put(date, 0L);
            map.put(date, map.get(date) + ((VideoSelectedEventDataRow) list.get(i)).getAmount());
        }
        return map;
    }

    public Map<Long, Map<String, Integer>> getCook() {
        List<EventDataRow> list = statisticStorage.getEventList(EventType.COOKED_ORDER);
        Map<Long, Map<String, Integer>> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            CookedOrderEventDataRow cookOEDR= (CookedOrderEventDataRow) list.get(i);
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(cookOEDR.getDate());
            calendar.set(Calendar.HOUR, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);
            long date = calendar.getTimeInMillis();
            if (!map.containsKey(date))
                map.put(date, new HashMap<>());
            if (!map.get(date).containsKey(cookOEDR.getCookName()))
                map.get(date).put(cookOEDR.getCookName(), 0);
            map.get(date).put(cookOEDR.getCookName(), map.get(date).get(cookOEDR.getCookName()) + cookOEDR.getTime());
        }
        return map;
    }
}
