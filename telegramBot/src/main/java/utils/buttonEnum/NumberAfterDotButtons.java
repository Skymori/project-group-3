package utils.buttonEnum;

public enum NumberAfterDotButtons {
    PRECISION("\uD83C\uDFAF Кол-во знаков после запятой"),
    PRECISION_TWO("2"),
    PRECISION_THREE("3"),
    PRECISION_FOUR("4");

    private final String precision;

    NumberAfterDotButtons(String precision) {
        this.precision = precision;
    }

    public String getPrecision() {
        return precision;
    }
}
