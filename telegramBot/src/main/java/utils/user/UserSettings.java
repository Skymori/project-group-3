package utils.user;

import utils.buttonEnum.BanksNameButtons;
import utils.buttonEnum.CurrencyNamesButtons;

import java.util.List;

public class UserSettings {


    private long chatId;
    private String name;
    private List<BanksNameButtons> bankList;
    private List<CurrencyNamesButtons> currencies;
    private int numberAfterDot;
    private int notifyHour;



    public UserSettings(long chatId, String name, List<BanksNameButtons> bankList, List<CurrencyNamesButtons> currencies, int numberAfterDot, int notifyHour) {
        this.chatId = chatId;
        this.name = name;
        this.bankList = bankList;
        this.currencies = currencies;
        this.numberAfterDot = numberAfterDot;
        this.notifyHour = notifyHour;
    }
    public long getChatId() {
        return chatId;
    }

    public void setChatId(long chatId) {
        this.chatId = chatId;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BanksNameButtons> getBankList() {
        return bankList;
    }

    public void setBankList(List<BanksNameButtons> bankList) {
        this.bankList = bankList;
    }

    public List<CurrencyNamesButtons> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(List<CurrencyNamesButtons> currencies) {
        this.currencies = currencies;
    }

    public int getNumberAfterDot() {
        return numberAfterDot;
    }

    public void setNumberAfterDot(int numberAfterDot) {
        this.numberAfterDot = numberAfterDot;
    }

    public int getNotifyHour() {
        return notifyHour;
    }

    public void setNotifyHour(int notifyHour) {
        this.notifyHour = notifyHour;
    }
}
