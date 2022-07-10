package vitals;


import java.util.*;

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

    private static boolean verifyBoundaryLimit(float input,Float minVal,Float maxVal) {
        return input > minVal && input < maxVal;
    }

    private static String returnLimitBreachMsg(Float minVal,Float maxVal,String inputType) {
        if (maxVal == null) {
            return boundaryConditions.get(inputType).lastEntry().getValue();
        } else {
            return boundaryConditions.get(inputType).firstEntry().getValue();
        }
    }


    public static boolean getBatteryStatusBasedOnSystemInput(String inputType, Float inputValue,CountryLocale languageChoice){

        String statusMsg = null;
        boolean batteryStatus = false;
        Float minVal = boundaryConditions.get(inputType).lowerKey(inputValue);
        Float maxVal = boundaryConditions.get(inputType).higherKey(inputValue);
        if(verifyBoundaryLimit(inputValue,minVal,maxVal)) {
            statusMsg = boundaryConditions.get(inputType).get(minVal);
            batteryStatus = true;
        } else {
            statusMsg = returnLimitBreachMsg(minVal,maxVal,inputType);
        }
        print(statusMsg,languageChoice);
        return batteryStatus;
    }

    private static void print(String msgKey,CountryLocale languageChoice) {
        String msgResult = LanguageLocalization.getMessageBasedOnLanguageChoice(msgKey,languageChoice);
        System.out.println(msgKey + ">>>" + msgResult);
    }



}
