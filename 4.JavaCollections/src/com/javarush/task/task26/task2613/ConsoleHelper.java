package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

public class ConsoleHelper {
    private static ResourceBundle res = ResourceBundle.getBundle(CashMachine.class.getPackage().getName() + ".resources.common_en");
    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException {
        try {
            String s = bis.readLine();
            if (s.toLowerCase().equals("exit")) {
                throw new InterruptOperationException();
            }
            return s;
        } catch (IOException ignored) {
        }
        return "";
    }

    public static String askCurrencyCode() throws InterruptOperationException {
        writeMessage(res.getString("choose.currency.code"));
        while (true) {
            String currency = readString();
            if (currency != null && currency.length() == 3) return currency.toUpperCase();
            writeMessage(res.getString("invalid.data"));
        }
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {
        writeMessage(String.format(res.getString("choose.denomination.and.count.format"), currencyCode));
        while (true) {
            String s = readString();
            if (s != null) {
                String[] ss = s.split(" ");
                if (ss.length == 2) {
                    try {
                        int den = Integer.parseInt(ss[0]);
                        int num = Integer.parseInt(ss[1]);
                        if (den > 0 && num > 0) return ss;
                    } catch (Exception ignored) {
                    }
                }
            }
            writeMessage(res.getString("invalid.data"));
        }
    }

    public static Operation askOperation() throws InterruptOperationException {
        while (true) {
            writeMessage(String.format("%s%n1 - %s%n2 - %s%n3 - %s%n4 - %s", res.getString("choose.operation"),
                    res.getString("operation.INFO"), res.getString("operation.DEPOSIT"),
                    res.getString("operation.WITHDRAW"), res.getString("operation.EXIT")));
            String s = readString();
            if (s == null) continue;
            try {
                return Operation.getAllowableOperationByOrdinal(Integer.parseInt(s));
            } catch (IllegalArgumentException ignored) {
            }
        }
    }

    public static void printExitMessage() {
        writeMessage(res.getString("the.end"));
    }
}
