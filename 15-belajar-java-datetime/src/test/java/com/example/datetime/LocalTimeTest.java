package com.example.datetime;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;

public class LocalTimeTest {
    @Test
    void create() {
        LocalTime localTime1 = LocalTime.now();
        LocalTime localTime2 = LocalTime.of(23, 30, 10);
        LocalTime localTime3 = LocalTime.parse("12:30");

        System.out.println(localTime1);
        System.out.println(localTime2);
        System.out.println(localTime3);
    }

    @Test
    void change() {
        LocalTime localTime1 = LocalTime.now();
        LocalTime localTime2 = localTime1.withHour(10);
        LocalTime localTime3 = localTime1.withHour(19).withMinute(10).withSecond(0);

        System.out.println(localTime1);
        System.out.println(localTime2);
        System.out.println(localTime3);
    }

    @Test
    void modify() {
        LocalTime localTime1 = LocalTime.now();
        LocalTime localTime2 = localTime1.plusHours(10);
        LocalTime localTime3 = localTime1.plusHours(5).minusMinutes(10).minusSeconds(10);

        System.out.println(localTime1);
        System.out.println(localTime2);
        System.out.println(localTime3);
    }

    @Test
    void get() {
        LocalTime localTime = LocalTime.now();

        System.out.println(localTime.getHour());
        System.out.println(localTime.getMinute());
        System.out.println(localTime.getSecond());
        System.out.println(localTime.getNano());
    }
}
