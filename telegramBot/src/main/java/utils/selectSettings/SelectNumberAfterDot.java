package utils.selectSettings;

import utils.user.UserService;
import utils.user.UserSettings;

public class SelectNumberAfterDot {
    UserService userService;

    public String getSelectNumberAfterDot(int current, long chatId) {
        return userService.getUserSettings(chatId).getNumberAfterDot() == current ? "✅ " + current : current + "";
    }

}
