package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public long greatVideo(List<Advertisement> list, long sum, int time) {
        if (time > timeSeconds) return -1;

        Advertisement a;
        List<Advertisement> list2 = new ArrayList<>();
        list2.addAll(list);
        List<Advertisement> list3 = new ArrayList<>();
        list3.addAll(list);
        int time3 = time;
        long sum3 = sum;
        for (int i = 0; i < storage.list().size(); i++) {
            a = storage.list().get(i);
            if (a.getHits() <= 0) continue;
            if (!list2.contains(a)) {
                list2.add(a);
                long sum2 = greatVideo(list2, sum3 + a.getAmountPerOneDisplaying(), time3 + a.getDuration());
                if (sum2 >= sum) {
                    int time2 = 0;
                    for (int j = 0; j < list2.size(); j++) {
                        time2 += list2.get(j).getDuration();
                    }
                    if (sum2 > sum || (sum2 == sum && time2 > time) || (sum2 == sum && time2 == time && list.size() > list2.size())) {
                        sum = sum2;
                        time = time2;
                        list.clear();
                        list.addAll(list2);
                    }
                }
                list2.clear();
                list2.addAll(list3);
            }
        }
        return sum;
    }

    public void processVideos() {
        if (storage.list().size() == 0) throw new NoVideoAvailableException();
        List<Advertisement> list = new ArrayList<>();

        greatVideo(list, 0, 0);
        Collections.sort(list, (o1, o2) -> {
            int o1amount = (int) (o1.getAmountPerOneDisplaying() * 1.0 / o1.getDuration() * 1000);
            int o2amount = (int) (o2.getAmountPerOneDisplaying() * 1.0 / o2.getDuration() * 1000);
            if (o1.getAmountPerOneDisplaying() == o2.getAmountPerOneDisplaying()) return o1amount - o2amount;
            return (int) (o2.getAmountPerOneDisplaying() - o1.getAmountPerOneDisplaying());
        });

        long amount = 0;
        int totalDuration = 0;
        for (int i = 0; i < list.size(); i++) {
            amount += list.get(i).getAmountPerOneDisplaying();
            totalDuration += list.get(i).getDuration();
        }
        StatisticManager.getInstance().register(new VideoSelectedEventDataRow(list, amount, totalDuration));

        for (int i = 0; i < list.size(); i++) {
            list.get(i).revalidate();
            ConsoleHelper.writeMessage(list.get(i).toString());
        }
    }
}
