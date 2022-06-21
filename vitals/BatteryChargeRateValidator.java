package vitals;

public class BatteryChargeRateValidator implements IBatteryStateValidator{

    private final float chargeRate;

    public BatteryChargeRateValidator(float chargeRate) {
        this.chargeRate = chargeRate;
    }

    @Override
    public boolean validateBatteryState() {
        if(this.chargeRate > 0.8) {
            System.out.println("Charge Rate is out of range!");
            return false;
        }
        return true;
    }
}
