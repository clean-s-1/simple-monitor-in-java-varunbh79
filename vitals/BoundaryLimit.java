package vitals;


import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class BoundaryLimit {

    static Map<String, NavigableMap<Float, String>> boundaryConditions = new TreeMap<>();


    public static void setBoundaryConditions(){
         NavigableMap<Float, String> socBoundaryMap = new TreeMap<>();
         socBoundaryMap.put(0f, "LOW_SOC_BREACH");
         socBoundaryMap.put(21f,"LOW_SOC_WARNING");
         socBoundaryMap.put(25f,"NORMAL_SOC");
         socBoundaryMap.put(76f,"HIGH_SOC_WARNING");
         socBoundaryMap.put(81f,"HIGH_SOC_BREACH");
         boundaryConditions.put("soc",socBoundaryMap);

        NavigableMap<Float, String> tempBoundaryMap = new TreeMap<>();
        tempBoundaryMap.put(0.0f,"LOW_TEMP_BREACH");
        tempBoundaryMap.put(1.0f, "LOW_TEMP_WARNING");
        tempBoundaryMap.put(2.0f, "NORMAL_TEMP");
        tempBoundaryMap.put(43.0f, "HIGH_TEMP_WARNING");
        tempBoundaryMap.put(46.0f, "HIGH_TEMP_BREACH");
        boundaryConditions.put("temp",tempBoundaryMap);

        NavigableMap<Float, String> chargeRateMap = new TreeMap<>();
        chargeRateMap.put(0.0f,"LOW_CHARGE_RATE_BREACH");
        chargeRateMap.put(0.1f, "LOW_CHARGE_RATE_WARNING");
        chargeRateMap.put(0.4f, "NORMAL_CHARGE_RATE");
        chargeRateMap.put(0.76f, "HIGH_CHARGE_RATE_WARNING");
        chargeRateMap.put(0.8f, "HIGH_CHARGE_RATE_BREACH");
        boundaryConditions.put("chargeRate",chargeRateMap);


    }



    public static boolean getBatteryStatusBasedOnSystemInput(String inputType, Float inputValue,CountryLocale languageChoice){

        String msgResult = null;
        boolean batteryStatus = false;
        float minVal = boundaryConditions.get(inputType).lowerKey(inputValue);
        float maxVal = boundaryConditions.get(inputType).higherKey(inputValue);
        if (inputValue > minVal && inputValue < maxVal) {
                msgResult = boundaryConditions.get(inputType).get(minVal);
                batteryStatus = true;
        }
        print(msgResult,languageChoice);
        return batteryStatus;
    }

    public static void print(String msgKey,CountryLocale languageChoice) {
        String msgResult = LanguageLocalization.getMessageBasedOnLanguageChoice(msgKey,languageChoice);
        System.out.println(msgKey + ">>>" + msgResult);
    }


}
