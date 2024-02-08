package i18n;

import org.junit.jupiter.api.Test;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class NumberFormatTest {
    @Test
    void testNumberFormat() {
        NumberFormat numberFormat = NumberFormat.getInstance();
        String format = numberFormat.format(10000000.5);
        System.out.println(format);
    }

    @Test
    void testNumberFormatIndonesia() {
        Locale locale = new Locale("id", "ID");
        NumberFormat numberFormat = NumberFormat.getInstance(locale);
        String format = numberFormat.format(10000000.5);
        System.out.println(format);
    }

    @Test
    void testNumberFormatParseIndonesia() {
        Locale locale = new Locale("id", "ID");
        NumberFormat numberFormat = NumberFormat.getInstance(locale);

        try {
            var number = numberFormat.parse("100.000.000,5").doubleValue();
            System.out.println(number);
        } catch (ParseException e) {
            System.out.println("Error: " + e);
        }
    }
}
