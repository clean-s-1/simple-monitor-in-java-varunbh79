package vitals;

public class BatterySOCValidator implements IBatteryStateValidator{

    private final float soc;

    public BatterySOCValidator(float soc) {
        this.soc = soc;
    }
    @Override
    public boolean validateBatteryState() {
         if(this.soc < 20 || this.soc > 80) {
            System.out.println("State of Charge is out of range!");
            return false;
        }
       return true;
    }
}
