package vitals;

public class BatteryTemperatureValidator implements IBatteryStateValidator{

    private final float temperature;

    public BatteryTemperatureValidator(float temperature) {
        this.temperature = temperature;
    }


    @Override
    public boolean validateBatteryState() {
        if(this.temperature < 0 || this.temperature > 45) {
            System.out.println("Temperature is out of range!");
            return false;
        }
        return true;
    }
}
