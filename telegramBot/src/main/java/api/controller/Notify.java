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
import utils.user.UserService;
import utils.user.UserSettings;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentMap;


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


        public String sendInfo(UserSettings userSettings) throws IOException, InterruptedException {
            Facade facade = new Facade();

            final HashSet<Banks> bankList = userSettings.getBankList();
            System.out.println(bankList.toString());

            final HashSet<CurrencyNames> currencies = userSettings.getCurrencies();
            System.out.println(currencies.toString());


            StringBuilder result = new StringBuilder();

            for (Banks banks : bankList) {
                List<BankResponce> bankInfo = facade.getBankInfo(banks.getName());
                result.append("Курс в: " + banks.getCommand() + "\n");

                for (CurrencyNames currency : currencies) {
                    List<BankResponce> collect = bankInfo.stream()
                            .filter(cur -> currency.getCommand().equals(cur.getCurrency()))
                            .collect(Collectors.toList());


                    for (BankResponce responce : collect) {
                        result.append(responce.getCurrency() + " Покупка: " + responce.getBuy() + " Продажа:" + responce.getSale() + "\n");
                    }
                    System.out.println(collect);
                }

            }

            return result.toString();
        }

//        String toPost (String message);{
//            Cha
//        }

        @SneakyThrows
        @Override
        public void run() {
            ConcurrentMap<Long, UserSettings> userMap;
            UserService userService = new UserService();
            userMap= userService.getUserMap();
            System.out.println(userMap.toString());
/////////////////////////

            try {
                execute(SendMessage.builder()
                        .text(userService.sendInfo(userService.getUserSettings(userId)))
                        .chatId(userId.toString())
                        .build());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            ///////////////////////

            System.out.println("timer2");

            Notify everyTwoHours = new Notify(new DefaultBotOptions());
            everyTwoHours.execute(SendMessage.builder().chatId("765380855").text("ДУУЖЕ Цікаве.." +
                    "" +
                    " \n \t нагадування з буквою і ІЇ").build());

        }
    }








}
