package vitals;

import java.util.List;

public class BatteryStatusValidator {

    private final List<IBatteryStateValidator> batteryStateValidators;

    public BatteryStatusValidator(List<IBatteryStateValidator> batteryStateValidators) {
        this.batteryStateValidators = batteryStateValidators;
    }

    public boolean validateBatteryStatus() {

        boolean finalResult = true;
        for(IBatteryStateValidator batteryStateValidator: batteryStateValidators) {
            boolean stageResult = batteryStateValidator.validateBatteryState();
            finalResult =  finalResult && stageResult;
        }
        return finalResult;
    }


}
