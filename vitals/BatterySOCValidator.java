package vitals;


public class BatterySOCValidator implements IBatteryStateValidator{

    private final float soc;
    private final CountryLocale countryLocale;


    public BatterySOCValidator(float soc,CountryLocale countryLocale) {
        this.soc = soc;
        this.countryLocale = countryLocale;
    }

    @Override
    public boolean validateBatteryState() {

       return BoundaryLimit.getBatteryStatusBasedOnSystemInput("soc",soc,countryLocale);
    }
}
