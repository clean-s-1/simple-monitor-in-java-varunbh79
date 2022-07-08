package vitals;

public class BatteryTemperatureValidator implements IBatteryStateValidator{

    private  float temperature;
    private final String metricUnit;
    private final CountryLocale countryLocale;


    public BatteryTemperatureValidator(float temperature, String metricUnit, CountryLocale countryLocale) {
        this.temperature = temperature;
        this.metricUnit = metricUnit;
        this.countryLocale = countryLocale;
    }

    @Override
    public float computeTemperatureData(float temperature) {
     if (this.metricUnit.equals(TemperatureUnit.CELSIUS.name())) {
            this.temperature = (temperature * 9 / 5) + 32;
        }
       return this.temperature;
    }

    @Override
    public boolean validateBatteryState() {
        this.temperature = computeTemperatureData(this.temperature);
        return   BoundaryLimit.getBatteryStatusBasedOnSystemInput("temp",this.temperature,countryLocale);
    }
}
