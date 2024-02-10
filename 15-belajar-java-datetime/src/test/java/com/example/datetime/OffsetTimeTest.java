package com.example.datetime;

import org.junit.jupiter.api.Test;

import java.time.*;

public class OffsetTimeTest {
    @Test
    void create() {
        OffsetTime offsetTime1 = OffsetTime.now();
        OffsetTime offsetTime2 = OffsetTime.now(ZoneId.of("GMT"));
        OffsetTime offsetTime3 = OffsetTime.of(LocalTime.now(), ZoneOffset.ofHours(5));
        OffsetTime offsetTime4 = OffsetTime.parse("10:10:10.123+07:00");

        System.out.println(offsetTime1);
        System.out.println(offsetTime2);
        System.out.println(offsetTime3);
        System.out.println(offsetTime4);

        OffsetDateTime offsetDateTime1 = OffsetDateTime.now();
        OffsetDateTime offsetDateTime2 = OffsetDateTime.now(ZoneId.of("GMT"));
        OffsetDateTime offsetDateTime3 = OffsetDateTime.of(LocalDateTime.now(), ZoneOffset.ofHours(5));
        OffsetDateTime offsetDateTime4 = OffsetDateTime.parse("2000-10-10T10:10:10.100+07:00");

        System.out.println(offsetDateTime1);
        System.out.println(offsetDateTime2);
        System.out.println(offsetDateTime3);
        System.out.println(offsetDateTime4);
    }

    @Test
    void toLocalTime() {
        LocalTime localTime1 = LocalTime.now();
        System.out.println(localTime1);

        OffsetTime offsetTime = localTime1.atOffset(ZoneOffset.ofHours(7));
        System.out.println(offsetTime);

        LocalTime localTime2 = offsetTime.toLocalTime();
        System.out.println(localTime2);
    }

    @Test
    void toLocalDateTime() {
        LocalDateTime localDateTime1 = LocalDateTime.now();
        System.out.println(localDateTime1);

        OffsetDateTime offsetDateTime = localDateTime1.atOffset(ZoneOffset.ofHours(5));
        System.out.println(offsetDateTime);

        LocalDateTime localDateTime2 = offsetDateTime.toLocalDateTime();
        System.out.println(localDateTime2);

        ZonedDateTime zonedDateTime = offsetDateTime.toZonedDateTime();
        System.out.println(zonedDateTime);
    }
}
