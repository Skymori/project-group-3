package utils.buttonEnum;

public enum TimerButtons {
    TIME_UPDATE("⏱  Время оповещений"),
    TIME_UPDATE_NINE("9"),
    TIME_UPDATE_THEN("10"),
    TIME_UPDATE_ELEVEN("11"),
    TIME_UPDATE_TWELVE("12"),
    TIME_UPDATE_THIRTEEN("13"),
    TIME_UPDATE_FOURTEEN("14"),
    TIME_UPDATE_FIFTEEN("15"),
    TIME_UPDATE_SIXTEEN("16"),
    TIME_UPDATE_SEVENTEEN("17"),
    TIME_UPDATE_EIGHTEEN("18"),
    TIME_UPDATE_DISABLE("Выключить уведомления");

    private final String timer;

    TimerButtons(String timer) {
        this.timer = timer;
    }

    public String getTimer() {
        return timer;
    }
}
