package vitals;

public enum TemperatureUnit {

    CELSIUS("Celsius"),
    FAHRENHEIT("Fahrenheit");

    private final String unitSelection;

    private TemperatureUnit(String unitSelection) {
        this.unitSelection = unitSelection;
    }

    String getUnitSelection() {
        return unitSelection;
    }
}
