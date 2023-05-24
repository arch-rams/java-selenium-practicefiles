package selenium;

public class LangSpecificLocators {
    public static final String baseLang = "EN-GB";
            //"DE-DE";

    public enum LocatorByLang {
        ACCEPT_COOKIE("Akzeptieren", "Accept"),
        CONFIGURE_COOKIE("Konfigurieren", "Configure"),

        PACKAGING_TYPE("Verpackungsart", "Packaging type"),
        PARCEL("Paket", "Parcel"),
        DOCUMENT("Dokument", "Document"),
        PALLET("Palette", "Pallet"),
        BULKY_GOODS("Sperrgut", "Bulky goods"),
        NS_PALLET("Nicht stapelbare Palette", "Non-stackable pallet"),
        TIRE("Reifen", "Tire"),
        SUITCASE("Koffer", "Suitcase"),

        WEIGHT("Gewicht (kg)", "Weight (kg)"),
        WIDTH("B", "W"),

        COMPARERATES("Tarife vergleichen", "Compare rates"),

        CONTINUE2("Fortsetzen", "Continue"),
        CONTINUE("Weiter", "Continue"),

        STATE("Staat", "State"),

        INVALID_LOGIN_MSG(
                "Bitte überprüfen Sie, ob Ihr Benutzername / Passwort korrekt eingegeben wurde",
                "Bad credentials, please verify that your username/password are correctly set"),
        EXISTING_USER_ERR_MSG(
                "Benutzer mit dieser E-Mail existiert bereits!", "User with this email already exists!"),
        WELCOME_MSG("Vielen Dank für Ihre Registrierung.", "Thanks for your registration."),

        GIFT("Geschenk", "Gift"),
        COMMERCIAL("Gewerblich", "Commercial"),
        PERSONAL("Persönlich", "Personal"),
        RETURN("Retoure", "Return"),
        CLAIM("Reparatur / Gewährleistung", "Claim"),

        TOTAL_AMOUNT("Gesamt:", "Total Amount"),
        CREDITCARD("Kreditkarte", "Credit card"),
        ;

        private String lang_de;
        private String lang_en;

        private String getLang_de() {
            return lang_de;
        }

        private String getLang_en() {
            return lang_en;
        }

        LocatorByLang(String de, String en) {
            this.lang_de = de;
            this.lang_en = en;
        }

        public String getByLang() {
            if (baseLang.equalsIgnoreCase("EN-GB")) {
                return getLang_en();
            } else return getLang_de();
        }
    }
}
