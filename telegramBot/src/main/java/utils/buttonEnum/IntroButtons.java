package utils.buttonEnum;

public enum IntroButtons {

        START("/start"),
        SETTINGS("⚙ Настройки"),
        INFO("✉  Получить инфо"),
        HELP("\uD83D\uDE91 Помощь"),
        BACK("Назад");

        private final String intro;

    IntroButtons(String intro) {
        this.intro = intro;
    }

    public String getIntro() {
            return intro;
        }
    }

