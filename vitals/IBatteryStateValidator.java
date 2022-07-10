package vitals;

public interface IBatteryStateValidator {

    boolean validateBatteryState();

    default float computeTemperatureData(float tempData) {
        return tempData;
    }
}
