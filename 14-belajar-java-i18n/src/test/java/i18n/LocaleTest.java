package i18n;

import org.junit.jupiter.api.Test;

import java.util.Locale;

public class LocaleTest {
    @Test
    void testNewLocale() {
        String language = "ja";
        String country = "JP";

        Locale locale = new Locale(language, country);

        System.out.println(locale.getLanguage());
        System.out.println(locale.getCountry());

        System.out.println(locale.getDisplayLanguage());
        System.out.println(locale.getDisplayCountry());
    }
}
