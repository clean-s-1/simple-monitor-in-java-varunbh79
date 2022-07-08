package vitals;

public class SystemInput {

    private Number inputParam;
    private String unitType ;

    public SystemInput(Number inputParam) {
        this.inputParam = inputParam;
    }

    public SystemInput(Number inputParam, String unitType) {
        this.inputParam = inputParam;
        this.unitType = unitType;
    }

    public Number getInputParam() {
        return inputParam;
    }

    public void setInputParam(Number inputParam) {
        this.inputParam = inputParam;
    }

    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }

}
