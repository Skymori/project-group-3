package utils.selectSettings;

import utils.user.UserService;


public class SelectBanks {
    UserService userService;
    public String getSelectBanks (String current, long chatId){
        int sizeList = userService.getUserSettings(chatId).getBankList().size();
        String result = "";
        for (int i = 0; i < sizeList; i++) {
            String saved = String.valueOf(userService.getUserSettings(chatId).getBankList());
            String [] split = saved.split(",");
            if (split[i].contains(current)){
                result = "✅ " + current;
            }else {
                result = current;
            }
            if (result.contains("✅ ")){
                return result;
            }
        }
        return result;
    }
}
