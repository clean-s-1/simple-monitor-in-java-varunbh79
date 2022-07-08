package vitals;

import java.util.Arrays;
import java.util.List;

public class BatteryManagementDemo {

    static boolean batteryIsOk(SystemInput temperatureData, SystemInput socData, SystemInput chargeRateData, CountryLocale countryLocale) {
       IBatteryStateValidator temperatureValidator = new BatteryTemperatureValidator(temperatureData.getInputParam().floatValue(),temperatureData.getUnitType(),countryLocale);
       IBatteryStateValidator socValidator = new BatterySOCValidator(socData.getInputParam().floatValue(),countryLocale);
       IBatteryStateValidator chargeRateValidator = new BatteryChargeRateValidator(chargeRateData.getInputParam().floatValue(),countryLocale);
       List<IBatteryStateValidator> batteryStateValidators = Arrays.asList(temperatureValidator,socValidator,chargeRateValidator);
       BatteryStatusValidator batteryStatusValidator = new BatteryStatusValidator(batteryStateValidators);
       return batteryStatusValidator.validateBatteryStatus();
    }


    public static void main(String[] args) {

        LanguageLocalization.setupLocalizationData();
        BoundaryLimit.setBoundaryConditions();
        CountryLocale languageChoice = CountryLocale.GERMAN;
        assert (batteryIsOk(new SystemInput(42, TemperatureUnit.FAHRENHEIT.name()),
                new SystemInput(45), new SystemInput(0.5f),languageChoice));
        assert (batteryIsOk(new SystemInput(12, TemperatureUnit.FAHRENHEIT.name()),
                new SystemInput(45), new SystemInput(0.4f),languageChoice));
        languageChoice = CountryLocale.ENGLISH;
        assert (batteryIsOk(new SystemInput(2, TemperatureUnit.FAHRENHEIT.name()),
                new SystemInput(32), new SystemInput(0.2f),languageChoice));


      /*  assert (batteryIsOk(25, 70, 0.7f));
        assert (batteryIsOk(50, 85, 0.0f));

        assert (batteryIsOk(50, 81, 0.0f));
        assert (!batteryIsOk(50, 10, 0.81f));
        assert (!batteryIsOk(50, 85, 1));

        assert(batteryIsOk(12, 40, 0.6f));
        assert(batteryIsOk(20, 50, 0.6f));
        assert(!batteryIsOk(45, 20, 0.8f));
        assert(!batteryIsOk(0, 80, 0.80f));*/


    }
}
