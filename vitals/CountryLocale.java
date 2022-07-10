package vitals;


public enum CountryLocale {

    ENGLISH("en"),
    GERMAN("de");

    private final String selection;

    private CountryLocale(String selection) {
        this.selection = selection;
    }

    String getSelection() {
        return selection;
    }

}
