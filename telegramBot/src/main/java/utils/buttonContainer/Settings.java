package utils.buttonContainer;

import lombok.Data;

@Data
public class Settings {

    private boolean isCheckUSD;
    private boolean isCheckEUR;
    private boolean isCheckRUR;
    private boolean isCheckMonoBank;
    private boolean isCheckPrivatBank;
    private boolean isCheckNBU;
    private Integer TimeUpdate;
    private boolean isCheckDisableTimeUpdate;
    private Integer precision;
    private Long chatId;

    public Settings(Long chatId) {
        this.chatId = chatId;
        isCheckUSD = true;
        isCheckEUR = false;
        isCheckRUR = false;
        isCheckMonoBank = false;
        isCheckPrivatBank = false;
        isCheckNBU = true;
        TimeUpdate = 9;
        isCheckDisableTimeUpdate = true;
        precision = 2;
    }
}
