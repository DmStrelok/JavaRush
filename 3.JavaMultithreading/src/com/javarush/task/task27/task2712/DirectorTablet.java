package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.Advertisement;
import com.javarush.task.task27.task2712.ad.StatisticAdvertisementManager;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.util.*;

public class DirectorTablet {
    public void printAdvertisementProfit() {
        Map<Long, Long> map = StatisticManager.getInstance().getVideo();
        long sum = 0;
        List<Long> dates = new ArrayList<>();
        map.forEach((date, integer) -> dates.add(date));
        Collections.sort(dates);
        for (int i = dates.size() - 1; i >= 0; i--) {
            ConsoleHelper.writeMessage(String.format(Locale.ENGLISH, "%1$td-%1$tb-%1$tY - %2$.2f", dates.get(i), map.get(dates.get(i)) * 1.0 / 100));
            sum += map.get(dates.get(i));
        }
        ConsoleHelper.writeMessage(String.format(Locale.ENGLISH, "Total - %.2f", sum * 1.0 / 100));
    }

    public void printCookWorkloading() {
        Map<Long, Map<String, Integer>> map = StatisticManager.getInstance().getCook();
        List<Long> dates = new ArrayList<>();
        map.forEach((date, map2) -> dates.add(date));
        Collections.sort(dates);
        for (int i = dates.size() - 1; i >= 0; i--) {
            ConsoleHelper.writeMessage(String.format(Locale.ENGLISH, "%1$td-%1$tb-%1$tY", dates.get(i)));
            List<String> names = new ArrayList<>();
            map.get(dates.get(i)).forEach((name, time) -> names.add(name));
            Collections.sort(names);
            for (int j = 0; j < names.size(); j++) {
                double r = map.get(dates.get(i)).get(names.get(j)) * 1.0 / 60;
                ConsoleHelper.writeMessage(String.format(Locale.ENGLISH, "%s - %.0f min", names.get(j), Math.ceil(map.get(dates.get(i)).get(names.get(j)) * 1.0 / 60)));
            }
        }
    }

    public void printActiveVideoSet() {
        List<Advertisement> video = StatisticAdvertisementManager.getInstance().getActiveVideo();
        Collections.sort(video, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                return o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase());
            }
        });
        for (int i = 0; i < video.size(); i++) {
            ConsoleHelper.writeMessage(String.format("%s - %d", video.get(i).getName(), video.get(i).getHits()));
        }
    }

    public void printArchivedVideoSet() {
        List<Advertisement> video = StatisticAdvertisementManager.getInstance().getInactiveVideo();
        Collections.sort(video, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                return o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase());
            }
        });
        for (int i = 0; i < video.size(); i++) {
            ConsoleHelper.writeMessage(video.get(i).getName());
        }
    }
}
