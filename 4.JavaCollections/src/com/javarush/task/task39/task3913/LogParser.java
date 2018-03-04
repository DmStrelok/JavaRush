package com.javarush.task.task39.task3913;

import com.javarush.task.task39.task3913.query.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogParser implements IPQuery, UserQuery, DateQuery, EventQuery, QLQuery {
    private Path logDir;

    public LogParser(Path logDir) {
        this.logDir = logDir;
    }

    private Set<LogRecord> getRecords(String ip, String user, Date after, Date before, Event event, String task, Status status) {
        return getRecords(new Condition() {
            @Override
            public boolean condition(LogRecord logRecord) {
                return (ip == null || logRecord.ip.equals(ip))
                        && (user == null || logRecord.user.equals(user))
                        && (after == null || logRecord.date.after(after))
                        && (before == null || logRecord.date.before(before))
                        && (event == null || logRecord.event.equals(event))
                        && (task == null || logRecord.taskNumber.equals(task))
                        && (status == null || logRecord.status.equals(status));
            }
        });
    }

    private Set<LogRecord> getRecords(Condition condition) {
        Set<LogRecord> logRecords = new HashSet<>();
        try {
            Files.walk(logDir).filter(Files::isRegularFile).filter(e -> e.toString().toLowerCase().endsWith(".log")).forEach(path->{
                try {
                    Files.lines(path).forEach(s -> {
                        LogRecord logRecord = new LogRecord(s);
                        if (condition.condition(logRecord)) {logRecords.add(logRecord);}
                    });
                } catch (IOException ignored) {}
            });
        } catch (IOException ignored) {}
        return logRecords;
    }

    //========== IPQuery ==========//

    private Set<String> getIPQuery(String user, Date after, Date before, Event event, Status status) {
        Set<String> set = new HashSet<>();
        getRecords(null, user, after, before, event, null, status).forEach(e -> set.add(e.ip));
        return set;
    }

    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        return getUniqueIPs(after, before).size();
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        return getIPQuery(null, after, before, null, null);
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        return getIPQuery(user, after, before, null, null);
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        return getIPQuery(null, after, before, event, null);
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        return getIPQuery(null, after, before, null, status);
    }

    //========== Class LogRecord ==========//

    private class LogRecord {
        private String ip;
        private String user;
        private Date date;
        private Event event;
        private String taskNumber;
        private Status status;

        LogRecord(String record) {
            String[] s = record.split("\t");
            ip = s[0].trim();
            user = s[1];
            try {
                date = new SimpleDateFormat("d.M.y H:m:s").parse(s[2]);
            } catch (ParseException ignored) {
            }
            String s2[] = s[3].split(" ");
            event = Event.valueOf(s2[0]);
            if (s2.length > 1) taskNumber = s2[1];
            status = Status.valueOf(s[4]);
        }
    }

    //========== Condition ==========//

    private abstract class Condition {
        boolean isDate(Date after, Date before, Date date) {
            return (after == null || date.after(after))
                    && (before == null || date.before(before));
        }

        public abstract boolean condition(LogRecord logRecord);
    }

    //========== UserQuery ==========//

    private Set<String> getUserQuery(String ip, Date after, Date before, Event event, String task) {
        Set<String> set = new HashSet<>();
        getRecords(ip, null, after, before, event, task, null).forEach(e -> set.add(e.user));
        return set;
    }

    @Override
    public Set<String> getAllUsers() {
        return getUserQuery(null, null, null, null, null);
    }

    @Override
    public int getNumberOfUsers(Date after, Date before) {
        return getUserQuery(null, after, before, null, null).size();
    }

    @Override
    public int getNumberOfUserEvents(String user, Date after, Date before) {
        Set<Event> set = new HashSet<>();
        getRecords(null, user, after, before, null, null, null).forEach(e -> set.add(e.event));
        return set.size();
    }

    @Override
    public Set<String> getUsersForIP(String ip, Date after, Date before) {
        return getUserQuery(ip, after, before, null, null);
    }

    @Override
    public Set<String> getLoggedUsers(Date after, Date before) {
        return getUserQuery(null, after, before, Event.LOGIN, null);
    }

    @Override
    public Set<String> getDownloadedPluginUsers(Date after, Date before) {
        return getUserQuery(null, after, before, Event.DOWNLOAD_PLUGIN, null);
    }

    @Override
    public Set<String> getWroteMessageUsers(Date after, Date before) {
        return getUserQuery(null, after, before, Event.WRITE_MESSAGE, null);
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before) {
        return getUserQuery(null, after, before, Event.SOLVE_TASK, null);
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before, int task) {
        return getUserQuery(null, after, before, Event.SOLVE_TASK, String.valueOf(task));
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before) {
        return getUserQuery(null, after, before, Event.DONE_TASK, null);
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before, int task) {
        return getUserQuery(null, after, before, Event.DONE_TASK, String.valueOf(task));
    }

    //========== DateQuery ==========//

    private Set<Date> getDateQuery(String user, Date after, Date before, Event event, String task, Status status) {
        Set<Date> set = new HashSet<>();
        getRecords(null, user, after, before, event, task, status).forEach(e -> set.add(e.date));
        return set;
    }

    @Override
    public Set<Date> getDatesForUserAndEvent(String user, Event event, Date after, Date before) {
        return getDateQuery(user, after, before, event, null, null);
    }

    @Override
    public Set<Date> getDatesWhenSomethingFailed(Date after, Date before) {
        return getDateQuery(null, after, before, null, null, Status.FAILED);
    }

    @Override
    public Set<Date> getDatesWhenErrorHappened(Date after, Date before) {
        return getDateQuery(null, after, before, null, null, Status.ERROR);
    }

    @Override
    public Date getDateWhenUserLoggedFirstTime(String user, Date after, Date before) {
        Set<Date> dates = getDateQuery(user, after, before, Event.LOGIN, null, null);
        if (dates.isEmpty()) return null;
        return dates.stream().min(Date::compareTo).get();
    }

    @Override
    public Date getDateWhenUserSolvedTask(String user, int task, Date after, Date before) {
        Set<Date> dates = getDateQuery(user, after, before, Event.SOLVE_TASK, String.valueOf(task), null);
        if (dates.isEmpty()) return null;
        return dates.stream().min(Date::compareTo).get();
    }

    @Override
    public Date getDateWhenUserDoneTask(String user, int task, Date after, Date before) {
        Set<Date> dates = getDateQuery(user, after, before, Event.DONE_TASK, String.valueOf(task), null);
        if (dates.isEmpty()) return null;
        return dates.stream().min(Date::compareTo).get();
    }

    @Override
    public Set<Date> getDatesWhenUserWroteMessage(String user, Date after, Date before) {
        return getDateQuery(user, after, before, Event.WRITE_MESSAGE, null, null);
    }

    @Override
    public Set<Date> getDatesWhenUserDownloadedPlugin(String user, Date after, Date before) {
        return getDateQuery(user, after, before, Event.DOWNLOAD_PLUGIN, null, null);
    }

    //========== EventQuery ==========//

    private Set<Event> getEventQuery(String ip, String user, Date after, Date before, Status status) {
        Set<Event> set = new HashSet<>();
        getRecords(ip, user, after, before, null, null, status).forEach(e -> set.add(e.event));
        return set;
    }

    @Override
    public int getNumberOfAllEvents(Date after, Date before) {
        return getEventQuery(null, null, after, before, null).size();
    }

    @Override
    public Set<Event> getAllEvents(Date after, Date before) {
        return getEventQuery(null, null, after, before, null);
    }

    @Override
    public Set<Event> getEventsForIP(String ip, Date after, Date before) {
        return getEventQuery(ip, null, after, before, null);
    }

    @Override
    public Set<Event> getEventsForUser(String user, Date after, Date before) {
        return getEventQuery(null, user, after, before, null);
    }

    @Override
    public Set<Event> getFailedEvents(Date after, Date before) {
        return getEventQuery(null, null, after, before, Status.FAILED);
    }

    @Override
    public Set<Event> getErrorEvents(Date after, Date before) {
        return getEventQuery(null, null, after, before, Status.ERROR);
    }

    @Override
    public int getNumberOfAttemptToSolveTask(int task, Date after, Date before) {
        return getRecords(null, null, after, before, Event.SOLVE_TASK, String.valueOf(task), null).size();
    }

    @Override
    public int getNumberOfSuccessfulAttemptToSolveTask(int task, Date after, Date before) {
        return getRecords(null, null, after, before, Event.DONE_TASK, String.valueOf(task), null).size();
    }

    @Override
    public Map<Integer, Integer> getAllSolvedTasksAndTheirNumber(Date after, Date before) {
        Map<Integer, Integer> map = new HashMap<>();
        getRecords(null, null, after, before, Event.SOLVE_TASK, null, null)
                .forEach(e -> {
                    Integer task = Integer.valueOf(e.taskNumber);
                    Integer i = map.get(task);
                    map.put(task, i == null ? 1 : ++i);
                });
        return map;
    }

    @Override
    public Map<Integer, Integer> getAllDoneTasksAndTheirNumber(Date after, Date before) {
        Map<Integer, Integer> map = new HashMap<>();
        getRecords(null, null, after, before, Event.DONE_TASK, null, null)
                .forEach(e -> {
                    Integer task = Integer.valueOf(e.taskNumber);
                    Integer i = map.get(task);
                    map.put(task, i == null ? 1 : ++i);
                });
        return map;
    }

    //========== QLQuery ==========//

    private Set<LogRecord> getAllRecords(String field, String value, String after, String before) {
        Date afterDate;
        Date beforeDate;
        try {
            if (after != null) afterDate = new SimpleDateFormat("d.M.y H:m:s").parse(after);
            else afterDate = null;
            if (before != null) beforeDate = new SimpleDateFormat("d.M.y H:m:s").parse(before);
            else beforeDate = null;
        switch (field) {
            case "ip": return getRecords(new Condition() {
                    @Override
                    public boolean condition(LogRecord logRecord) {
                        return value == null || logRecord.ip.equals(value)
                                && isDate(afterDate, beforeDate, logRecord.date);
                    }
                });
            case "user": return getRecords(new Condition() {
                @Override
                public boolean condition(LogRecord logRecord) {
                    return value == null || logRecord.user.equals(value)
                            && isDate(afterDate, beforeDate, logRecord.date);
                }
            });
            case "date": return getRecords(new Condition() {
                @Override
                public boolean condition(LogRecord logRecord) {
                    try {
                        return value == null || logRecord.date.equals(new SimpleDateFormat("d.M.y H:m:s").parse(value))
                                && isDate(afterDate, beforeDate, logRecord.date);
                    } catch (ParseException ignored) {}
                    return false;
                }
            });
            case "event": return getRecords(new Condition() {
                @Override
                public boolean condition(LogRecord logRecord) {
                    return value == null || logRecord.event.equals(Event.valueOf(value))
                            && isDate(afterDate, beforeDate, logRecord.date);
                }
            });
            case "status": return getRecords(new Condition() {
                @Override
                public boolean condition(LogRecord logRecord) {
                    return value == null || logRecord.status.equals(Status.valueOf(value))
                            && isDate(afterDate, beforeDate, logRecord.date);
                }
            });
        }
        } catch (ParseException ignored) {}
        return new HashSet<>();
    }

    @Override
    public Set<Object> execute(String query) {
        Set<Object> set = new HashSet<>();
        if (query == null || query.isEmpty()) return set;

        Pattern pattern = Pattern.compile("get (ip|user|date|event|status)"
                + "( for (ip|user|date|event|status) = \"(.*?)\")?"
                + "( and date between \"(.*?)\" and \"(.*?)\")?");
        Matcher matcher = pattern.matcher(query);
        String field1 = null;
        String field2 = null;
        String value = null;
        String after = null;
        String before = null;
        if (matcher.find()) {
            field1 = matcher.group(1);
            field2 = matcher.group(3);
            value = matcher.group(4);
            after = matcher.group(6);
            before = matcher.group(7);
        }
        if (field1 == null) return null;
        if (field2 == null) field2 = field1;
        switch (field1) {
            case "ip": getAllRecords(field2, value, after, before).forEach(e -> set.add(e.ip)); break;
            case "user": getAllRecords(field2, value, after, before).forEach(e -> set.add(e.user)); break;
            case "date": getAllRecords(field2, value, after, before).forEach(e -> set.add(e.date)); break;
            case "event": getAllRecords(field2, value, after, before).forEach(e -> set.add(e.event)); break;
            case "status": getAllRecords(field2, value, after, before).forEach(e -> set.add(e.status)); break;
        }
        return set;
    }
}