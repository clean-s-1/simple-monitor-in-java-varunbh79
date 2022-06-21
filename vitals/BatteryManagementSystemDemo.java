package vitals;

import java.util.List;

public class BatteryManagementSystemDemo {

    static boolean batteryIsOk(float temperature, float soc, float chargeRate) {
       IBatteryStateValidator temperatureValidator = new BatteryTemperatureValidator(temperature);
       IBatteryStateValidator socValidator = new BatterySOCValidator(soc);
       IBatteryStateValidator chargeRateValidator = new BatteryChargeRateValidator(chargeRate);
       List<IBatteryStateValidator> batteryStateValidators = List.of(temperatureValidator,socValidator,chargeRateValidator);
       BatteryStatusValidator batteryStatusValidator = new BatteryStatusValidator(batteryStateValidators);
       return batteryStatusValidator.validateBatteryStatus();
    }


    public static void main(String[] args) {
        assert (batteryIsOk(25, 70, 0.7f));
        assert (!batteryIsOk(50, 85, 0.0f));

        assert (!batteryIsOk(50, 81, 0.0f));
        assert (!batteryIsOk(50, 10, 0.81f));
        assert (!batteryIsOk(50, 85, 1));

        assert(batteryIsOk(12, 40, 0.6f));
        assert(batteryIsOk(20, 50, 0.6f));
        assert(!batteryIsOk(45, 20, 0.8f));
        assert(!batteryIsOk(0, 80, 0.80f));
    }
}
