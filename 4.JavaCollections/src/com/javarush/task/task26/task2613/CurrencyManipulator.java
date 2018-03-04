package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.util.*;

public class CurrencyManipulator {
    private String currencyCode;
    private Map<Integer, Integer> denominations = new HashMap<>();

    public CurrencyManipulator(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void addAmount(int denomination, int count) {
        if (!denominations.containsKey(denomination)) denominations.put(denomination, 0);
        denominations.put(denomination, denominations.get(denomination) + count);
    }
    
    public int getTotalAmount() {
        int sum = 0;
        for (Map.Entry<Integer, Integer> p : denominations.entrySet()) {
            sum += p.getKey() * p.getValue();
        }
        return sum;
    }

    public boolean hasMoney() {
        if (denominations.size() != 0) return true;
        return false;
    }

    public boolean isAmountAvailable(int expectedAmount) {
        return expectedAmount >= 0 && expectedAmount <= getTotalAmount();
    }

    private int great(Map<Integer, Integer> map, List<Integer> list, int expectedAmount, int sum, int den) {
        if (sum > expectedAmount) return -1;
        if (sum == expectedAmount) return sum;
        for (Integer d : list) {
            if (d <= den && denominations.get(d) > 0) {
                map.put(d, map.get(d) + 1);
                denominations.put(d, denominations.get(d) - 1);
                sum += d;
                int result = great(map, list, expectedAmount, sum, d);
                if (result == -1) {
                    denominations.put(d, denominations.get(d) + 1);
                    map.put(d, map.get(d) - 1);
                    sum -= d;
                }
                else if (result == expectedAmount) return result;
            }
        }
        return -1;
    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException {
        Map<Integer, Integer> den = new HashMap<>();
        List<Integer> list = new ArrayList<>(denominations.keySet());
        list.sort(Comparator.comparingInt(o -> -o));
        for (Integer i : list) {
            den.put(i, 0);
        }
        int result = great(den, list, expectedAmount, 0, list.get(0));
        if (result != expectedAmount) throw new NotEnoughMoneyException();
        for (Integer i : list) {
            if (den.get(i) == 0) den.remove(i);
        }
        return den;
    }
}
