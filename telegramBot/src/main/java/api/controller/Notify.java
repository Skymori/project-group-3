package api.controller;
import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.DefaultAbsSender;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Timer;
import java.util.TimerTask;


public class Notify extends DefaultAbsSender {
    public Notify (DefaultBotOptions options){
        super(options);
    }
    @Override
    public String getBotToken() {
        return "5091935773:AAFZ-XHxAVtXqf0wBleCkSyEYlThrqBII08";
    }



    private Timer mTimer = new Timer();
    private MyTimerTask mMyTimerTask = new MyTimerTask();

    public void startTimer(){
        // 1000 - время в мс, через которое будет запущена задача
        mTimer.schedule(mMyTimerTask, 18000,18000);
    }

    class MyTimerTask extends TimerTask {

//        String toPost (String message);{
//            Cha
//        }

        @SneakyThrows
        @Override
        public void run() {
            System.out.println("timer2");

            Notify everyTwoHours = new Notify(new DefaultBotOptions());
            everyTwoHours.execute(SendMessage.builder().chatId("765380855").text("ДУУЖЕ Цікаве.." +
                    "" +
                    " \n \t нагадування з буквою і ІЇ").build());

        }
    }








}
