package com.javarush.task.task39.task3913;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

public class Solution {
    public static void main(String[] args) {
        Path path = Paths.get(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath().substring(1) + Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/logs");

        LogParser logParser = new LogParser(path);
        System.out.println(logParser.getNumberOfUniqueIPs(null, null));
        System.out.println(logParser.getUniqueIPs(null, null));
        System.out.println(logParser.getIPsForUser("Eduard Petrovich Morozko", null, null));
        System.out.println(logParser.getIPsForEvent(Event.SOLVE_TASK, null, null));
        System.out.println(logParser.getIPsForStatus(Status.FAILED, null, null));
        System.out.println(logParser.getAllUsers());
        System.out.println(logParser.getLoggedUsers(null, new Date()));
        System.out.println(logParser.getSolvedTaskUsers(null, null));
        System.out.println(logParser.getSolvedTaskUsers(null, null, 1));
        System.out.println(logParser.getDoneTaskUsers(null, null));
        System.out.println(logParser.getDateWhenUserLoggedFirstTime("Eduard Petrovich Morozko", new Date(), null));
        System.out.println(logParser.getDateWhenUserLoggedFirstTime("Eduard Petrovich Morozko", null, null));
        System.out.println(logParser.getDateWhenUserDoneTask("Eduard Petrovich Morozko", 48, null, null));
        System.out.println(logParser.getNumberOfAttemptToSolveTask(18, null, null));
        System.out.println(logParser.getAllSolvedTasksAndTheirNumber(null, null));
        System.out.println(logParser.execute("get ip"));
        System.out.println(logParser.execute("get event for date = \"03.01.2014 03:45:23\""));
        System.out.println(logParser.execute("get ip for event = \"SOLVE_TASK\""));
        System.out.println(logParser.execute("get ip for user = \"Eduard Petrovich Morozko\" and date between \"11.12.2013 0:00:00\" and \"03.01.2014 23:59:59\""));
        System.out.println(logParser.execute("get event for date = \"3.1.2014 3:45:23\""));
        System.out.println(logParser.execute("get event for date = \"03.01.2014 3:45:23\""));
        System.out.println(logParser.execute("get event for date = \"\""));
        System.out.println(logParser.execute("get date for date = \"29.2.2028 05:4:7\""));
        System.out.println(logParser.execute("get user for date = \"29.02.2028 05:4:07\""));
    }
}