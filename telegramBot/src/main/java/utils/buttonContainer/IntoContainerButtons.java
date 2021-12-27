package utils.buttonContainer;

import api.controller.TelegramImplementations;
import com.google.common.collect.ImmutableMap;

import java.util.HashMap;
import java.util.Map;

public class IntoContainerButtons {
    private final ImmutableMap<String,Button> buttonMap;
    private Map<Long, Settings> userSettings;

    public IntoContainerButtons(TelegramImplementations telegramImplementations) {
        userSettings = new HashMap<>();

    }
}
