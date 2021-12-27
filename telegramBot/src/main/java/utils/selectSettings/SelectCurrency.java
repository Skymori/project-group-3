package utils.selectSettings;

import utils.user.UserService;

public class SelectCurrency {
    UserService userService;

    public String getSelectCurrency(String current, Long chatId) {
        int sizeList = userService.getUserSettings(chatId).getCurrencies().size();
        String result = "";
        for (int i = 0; i < sizeList; i++) {
            String saved = String.valueOf(userService.getUserSettings(chatId).getCurrencies());
            String[] split = saved.split(",");
            if (split[i].contains(current)) {
                result = "✅ " + current;
            } else {
                result = current;
            }
            if (result.contains("✅ ")) {
                return result;
            }
        }
        return result;

    }
}
