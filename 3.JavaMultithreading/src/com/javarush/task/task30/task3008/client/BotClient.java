package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class BotClient extends Client {

    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {
        return "date_bot_".concat(String.valueOf((int) (Math.random() * 100)));
    }

    public class BotSocketThread extends SocketThread {
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
            String name;
            String text = "";
            if (message.indexOf(":") > 0) {
                name = message.substring(0, message.indexOf(":"));
                if (name.length() + 2 < message.length()) {
                    text = message.substring(name.length() + 2);
                    name = "Информация для ".concat(name).concat(": ");
                    Calendar calendar = new GregorianCalendar();
                    if (text.equals("дата"))
                        sendTextMessage(name + new SimpleDateFormat("d.MM.YYYY").format(calendar.getTime()));
                    if (text.equals("день"))
                        sendTextMessage(name + new SimpleDateFormat("d").format(calendar.getTime()));
                    if (text.equals("месяц"))
                        sendTextMessage(name + new SimpleDateFormat("MMMM").format(calendar.getTime()));
                    if (text.equals("год"))
                        sendTextMessage(name + new SimpleDateFormat("YYYY").format(calendar.getTime()));
                    if (text.equals("время"))
                        sendTextMessage(name + new SimpleDateFormat("H:mm:ss").format(calendar.getTime()));
                    if (text.equals("час"))
                        sendTextMessage(name + new SimpleDateFormat("H").format(calendar.getTime()));
                    if (text.equals("минуты"))
                        sendTextMessage(name + new SimpleDateFormat("m").format(calendar.getTime()));
                    if (text.equals("секунды"))
                        sendTextMessage(name + new SimpleDateFormat("s").format(calendar.getTime()));
                }
            }
        }
    }
}
