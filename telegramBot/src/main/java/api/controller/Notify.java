package api.controller;

import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.DefaultAbsSender;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import utils.user.UserService;
import utils.user.UserSettings;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalTime;
import java.util.*;


public class Notify extends DefaultAbsSender {
    public Notify(DefaultBotOptions options) {
        super(options);
    }

    @Override
    public String getBotToken() {
        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String appConfigPath = rootPath + "r.properties";
        Properties appProps = new Properties();

        try {
            appProps.load(new FileInputStream(appConfigPath));

            return appProps.getProperty("bot.token");
        } catch (FileNotFoundException e) {

        } catch (IOException e) {
            e.printStackTrace();
        }


        return "is not find";
    }


    private Timer mTimer = new Timer();
    private MyTimerTask mMyTimerTask = new MyTimerTask();

    public void startTimer() {
        // 1000 - время в мс, через которое будет запущена задача
        mTimer.schedule(mMyTimerTask, 60000, 60000);
    }

    class MyTimerTask extends TimerTask {

        @SneakyThrows
        @Override
        public void run() {

            Map<Long, UserSettings> userMap;
            UserService userService = new UserService();
            userMap = userService.getUserMap();

            TelegramImplementations telegramImplementations = new TelegramImplementations();

            LocalTime timeNow = LocalTime.now();
            int hourNow = timeNow.getHour();
            int minuteNow = timeNow.getMinute();
            int notifyUserHour;

            UserSettings us;
            Iterator iterator = userMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry pair = (Map.Entry) iterator.next();
                us = (UserSettings) pair.getValue();
                notifyUserHour = us.getNotifyHour();

                if (minuteNow == 0 && notifyUserHour == hourNow) {
                    try {

                        execute(SendMessage.builder()
                                .text(telegramImplementations.sendInfo(us))
                                .chatId(pair.getKey().toString())
                                .build());
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }


            }

        }
    }


}
