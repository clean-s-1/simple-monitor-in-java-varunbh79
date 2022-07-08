package vitals;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LanguageLocalization {

    static Map<CountryLocale,Map<String,String>> localizationMap = new ConcurrentHashMap<>();

    public static void setupLocalizationData() {

        Map<String,String> statusIndicatorMapInEnglish= new ConcurrentHashMap<>();
        Map<String,String> statusIndicatorMapInGerman = new ConcurrentHashMap<>();
        
        statusIndicatorMapInEnglish.put("LOW_SOC_BREACH", "BREACH::: ====>  Charge State is out of range!");
        statusIndicatorMapInEnglish.put("LOW_SOC_WARNING", "WARNING::: ====> Charge State approaching Discharge Mode!");
        statusIndicatorMapInEnglish.put("NORMAL_SOC", "NORMAL::: ====>  Charge State is in range!");
        statusIndicatorMapInEnglish.put("HIGH_SOC_WARNING", "WARNING::: ====>  Charge State is approaching peak-charge Mode !");
        statusIndicatorMapInEnglish.put("HIGH_SOC_BREACH", "BREACH::: ====>  Charge State is out of range!");
        statusIndicatorMapInEnglish.put("LOW_TEMP_BREACH", "BREACH::: ====> Temperature  is out of range!");
        statusIndicatorMapInEnglish.put("LOW_TEMP_WARNING", "WARNING::: ====> Temperature  is approaching for breach!");
        statusIndicatorMapInEnglish.put("NORMAL_TEMP", "NORMAL::: ====> Temperature  is in of range!");
        statusIndicatorMapInEnglish.put("HIGH_TEMP_WARNING", "WARNING::: ====> Temperature  is approaching for breach!");
        statusIndicatorMapInEnglish.put("HIGH_TEMP_BREACH", "BREACH::: ====> Temperature is out of range!");
        statusIndicatorMapInEnglish.put("LOW_CHARGE_RATE_BREACH", "BREACH::: ====> Charge Rate  is out of range!");
        statusIndicatorMapInEnglish.put("LOW_CHARGE_RATE_WARNING", "WARNING::: ====> Charge Rate is approaching for breach!");
        statusIndicatorMapInEnglish.put("NORMAL_CHARGE_RATE", "NORMAL::: ====> Charge Rate is in  range!");
        statusIndicatorMapInEnglish.put("HIGH_CHARGE_RATE_WARNING", "WARNING::: ====> Charge Rate is approaching for breach!");
        statusIndicatorMapInEnglish.put("HIGH_CHARGE_RATE_BREACH", "BREACH::: ====> Charge Rate is out of range!");

        localizationMap.put(CountryLocale.ENGLISH,statusIndicatorMapInEnglish);

        statusIndicatorMapInGerman.put("LOW_SOC_BREACH", "BREACH::: ====> Der Ladezustand ist außerhalb des Bereichs!");
        statusIndicatorMapInGerman.put("LOW_SOC_WARNING", "WARNUNG::: ====> Der Ladezustand nähert sich einer Verletzung!");
        statusIndicatorMapInGerman.put("NORMAL_SOC", "NORMAL::: ====> Ladezustand ist in Reichweite!");
        statusIndicatorMapInGerman.put("HIGH_SOC_WARNING", "WARNUNG::: ====> Der Ladezustand nähert sich einer Verletzung!");
        statusIndicatorMapInGerman.put("HIGH_SOC_BREACH", "BREACH::: ====> Der Ladezustand ist außerhalb des Bereichs!");

        statusIndicatorMapInGerman.put("LOW_TEMP_BREACH", "BREACH::: ====> Temperatur außerhalb des zulässigen Bereichs!");
        statusIndicatorMapInGerman.put("LOW_TEMP_WARNING", "WARNUNG::: ====> Die Temperatur nähert sich dem Durchbruch!");
        statusIndicatorMapInGerman.put("NORMAL_TEMP", "NORMAL::: ====> Temperatur ist im Bereich!");
        statusIndicatorMapInGerman.put("HIGH_TEMP_WARNING", "WARNUNG::: ====> Die Temperatur nähert sich dem Durchbruch!");
        statusIndicatorMapInGerman.put("HIGH_TEMP_BREACH", "BREACH::: ====> Temperatur außerhalb des zulässigen Bereichs!");

        statusIndicatorMapInGerman.put("LOW_CHARGE_RATE_BREACH", "BREACH::: ====> Die Laderate ist außerhalb des zulässigen Bereichs!");
        statusIndicatorMapInGerman.put("LOW_CHARGE_RATE_WARNING", "WARNUNG::: ====> Die Laderate nähert sich der Verletzung!");
        statusIndicatorMapInGerman.put("NORMAL_CHARGE_RATE", "NORMAL::: ====> DISCharge Rate liegt im Bereich!");
        statusIndicatorMapInGerman.put("HIGH_CHARGE_RATE_WARNING", "WARNUNG::: ====> Die Laderate nähert sich der Verletzung!");
        statusIndicatorMapInGerman.put("HIGH_CHARGE_RATE_BREACH", "BREACH::: ====> Die Laderate ist außerhalb des zulässigen Bereichs!");

        localizationMap.put(CountryLocale.GERMAN,statusIndicatorMapInGerman);
    }

    public static String getMessageBasedOnLanguageChoice(String msgResult,CountryLocale languageChoice) {

        if(localizationMap == null || localizationMap.isEmpty()) {
            LanguageLocalization.setupLocalizationData();
        }
            return localizationMap.get(languageChoice).get(msgResult);

    }

}
