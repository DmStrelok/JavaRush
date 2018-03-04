package com.javarush.task.task26.task2613;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CurrencyManipulatorFactory {
    private static Map<String, CurrencyManipulator> map = new HashMap<>();

/*    static {
        CurrencyManipulator currencyManipulator = new CurrencyManipulator("QQQ");
        map.put("qqq", currencyManipulator);
        currencyManipulator.addAmount(500, 2);
        currencyManipulator.addAmount(200, 3);
        currencyManipulator.addAmount(100, 1);
        currencyManipulator.addAmount(50, 12);
    }*/

    private CurrencyManipulatorFactory() {
    }

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode) {
        if (currencyCode == null) return null;
        if (map.containsKey(currencyCode.toLowerCase())) return map.get(currencyCode.toLowerCase());
        CurrencyManipulator currencyManipulator = new CurrencyManipulator(currencyCode);
        map.put(currencyCode.toLowerCase(), currencyManipulator);
        return currencyManipulator;
    }

    public static Collection<CurrencyManipulator> getAllCurrencyManipulators() {
        return map.values();
    }
}
