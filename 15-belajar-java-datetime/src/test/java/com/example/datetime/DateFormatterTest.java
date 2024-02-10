package com.example.datetime;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateFormatterTest {
    @Test
    void parsing() {
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy MM dd");
        LocalDate localDate = LocalDate.parse("2023 05 12", pattern);
        System.out.println(localDate);
    }

    @Test
    void format() {
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy MM dd");

        LocalDate localDate = LocalDate.parse("2023 05 12", pattern);
        String formatted = localDate.format(pattern);

        System.out.println(formatted);
    }

    @Test
    void defaultFormat() {
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy MM dd");

        LocalDate localDate = LocalDate.parse("2023 05 12", pattern);
        String formatted = localDate.format(DateTimeFormatter.ISO_LOCAL_DATE);

        System.out.println(formatted);
    }

    @Test
    void i18n() {
        Locale locale = new Locale("id", "ID");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MMMM dd", locale);

        LocalDate localDate = LocalDate.now();
        String formatted = localDate.format(formatter);

        System.out.println(formatted);
    }
}
