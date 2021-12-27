package utils.buttonEnum;

public enum BanksNameButtons {
    BANK("\uD83C\uDFE6 Банк"),
    PRIVATBANK("Приватбанк"),
    MONOBANK("Монобанк"),
    NBU("НБУ");

    private final String value;

    BanksNameButtons(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
