package vitals;

public class BatteryChargeRateValidator implements IBatteryStateValidator{

    private final float chargeRate;
    private final CountryLocale countryLocale;

    public BatteryChargeRateValidator(float chargeRate,CountryLocale countryLocale) {
        this.chargeRate = chargeRate;
        this.countryLocale = countryLocale;
    }

    @Override
    public boolean validateBatteryState() {

        return BoundaryLimit.getBatteryStatusBasedOnSystemInput("chargeRate",chargeRate,countryLocale);
    }
}
