package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.ResourceBundle;

public class LoginCommand implements Command {
    private ResourceBundle validCreditCards = ResourceBundle.getBundle(CashMachine.class.getPackage().getName() + ".resources.verifiedCards");
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "login_en");

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));
        ConsoleHelper.writeMessage(res.getString("specify.data"));
        while (true) {
            String s1 = ConsoleHelper.readString();
            String s2 = ConsoleHelper.readString();
            if (s1 != null && s2 != null) {
                if (s1.matches("^\\d{12}$") && s2.matches("^\\d{4}$")) {
                    if (validCreditCards.containsKey(s1))
                        if (validCreditCards.getString(s1).equals(s2)) {
                            ConsoleHelper.writeMessage(String.format(res.getString("success.format"), s1));
                            return;
                        }
                        else ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), s1));
                    else ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
                }
                else ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
            }
        }
    }
}
