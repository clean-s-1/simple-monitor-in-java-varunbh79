package vitals;

import java.util.List;

public class BatteryStatusValidator {

    private final List<IBatteryStateValidator> batteryStateValidators;

    public BatteryStatusValidator(List<IBatteryStateValidator> batteryStateValidators) {
        this.batteryStateValidators = batteryStateValidators;
    }

    public boolean validateBatteryStatus() {

        boolean result = true;
        for(IBatteryStateValidator batteryStateValidator: batteryStateValidators) {
            result = batteryStateValidator.validateBatteryState();
        }
        return result;
    }
}
