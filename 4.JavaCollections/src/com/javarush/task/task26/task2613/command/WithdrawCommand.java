package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;
import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.util.*;

class WithdrawCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "withdraw_en");

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));
        String currentCode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currentCode);
        if (currencyManipulator.hasMoney()) {
            while (true) {
                ConsoleHelper.writeMessage(res.getString("specify.amount"));
                String moneyS = ConsoleHelper.readString();
                try {
                    int money = Integer.parseInt(moneyS);
                    if (!currencyManipulator.isAmountAvailable(money)) {
                        if (money < 0) ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
                        else ConsoleHelper.writeMessage(res.getString("not.enough.money"));
                        continue;
                    }
                    try {
                        Map<Integer, Integer> den = currencyManipulator.withdrawAmount(money);
                        List<Integer> list = new ArrayList<>(den.keySet());
                        list.sort(Comparator.comparingInt(o -> -o));
                        for (Integer i : list) {
                            ConsoleHelper.writeMessage("\t" + i + " - " + den.get(i));
                        }
                        ConsoleHelper.writeMessage(String.format(res.getString("success.format"), money, currentCode));
                        return;
                    } catch (NotEnoughMoneyException e) {
                        ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));
                    }
                } catch (NumberFormatException ignored) {
                }
            }
        }
    }
}
