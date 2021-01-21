package p.tomaszewski.FastRace.enums;

public enum Surface {
    ASPHALT("asphalt"),
    GRAVEL("gravel"),
    CONCRETE("concrete");

    private final String displayValue;

    Surface(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
