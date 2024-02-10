package com.example.datetime;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class TimeZoneTest {
    @Test
    void create() {
        TimeZone defaultTimeZone = TimeZone.getDefault();
        System.out.println(defaultTimeZone);

        TimeZone timeZoneGMT = TimeZone.getTimeZone("GMT");
        System.out.println(timeZoneGMT);

        String[] availableIds = TimeZone.getAvailableIDs();
        Arrays.asList(availableIds).forEach(System.out::println);
    }

    @Test
    void date() {
        Date date = new Date();
        System.out.println(date);
        System.out.println(date.toGMTString());
    }

    @Test
    void calendar() {
        Calendar calendarJakarta = Calendar.getInstance(TimeZone.getTimeZone("Asia/Jakarta"));
        Calendar calendarGMT = Calendar.getInstance(TimeZone.getTimeZone("GMT"));

        System.out.println(calendarJakarta.get(Calendar.HOUR_OF_DAY));
        System.out.println(calendarGMT.get(Calendar.HOUR_OF_DAY));

        calendarJakarta.setTimeZone(TimeZone.getTimeZone("GMT"));
        System.out.println(calendarJakarta.get(Calendar.HOUR_OF_DAY));
    }
}
