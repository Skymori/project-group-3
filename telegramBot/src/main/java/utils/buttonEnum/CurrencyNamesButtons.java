package utils.buttonEnum;

public enum CurrencyNamesButtons {
    CURRENCY("\uD83D\uDCB0 Валюта"),
    USD("USD"),
    RUB("RUB"),
    EUR("EUR");

    private final String value;

    CurrencyNamesButtons(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
