package com.example.datetime;

import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.temporal.*;
import java.util.ArrayList;
import java.util.List;

public class TemporalTest {
    @Test
    void temporal() {
        Temporal temporal1 = LocalDate.now();
        Temporal temporal2 = LocalTime.now();
        Temporal temporal3 = LocalDateTime.now();
        Temporal temporal4 = ZonedDateTime.now();
        Temporal temporal5 = OffsetTime.now();
        Temporal temporal6 = OffsetDateTime.now();
        Temporal temporal7 = Year.now();
        Temporal temporal8 = YearMonth.now();
        Temporal temporal9 = Instant.now();

        System.out.println(temporal1);
        System.out.println(temporal2);
        System.out.println(temporal3);
        System.out.println(temporal4);
        System.out.println(temporal5);
        System.out.println(temporal6);
        System.out.println(temporal7);
        System.out.println(temporal8);
        System.out.println(temporal9);
    }

    @Test
    void temporalAmount() {
        Temporal temporal1 = LocalDateTime.now();
        Temporal temporal2 = temporal1.plus(Duration.ofHours(10));
        Temporal temporal3 = temporal1.plus(Period.ofDays(10));

        System.out.println(temporal1);
        System.out.println(temporal2);
        System.out.println(temporal3);
    }

    @Test
    void temporalUnit() {
        long between = ChronoUnit.MINUTES.between(
                LocalTime.now(),
                LocalTime.now().plusHours(10)
        );

        System.out.println(between);
    }

    @Test
    void temporalField() {
        Temporal temporal = LocalDateTime.now();

        System.out.println(temporal.get(ChronoField.YEAR));
        System.out.println(temporal.get(ChronoField.MONTH_OF_YEAR));
        System.out.println(temporal.get(ChronoField.DAY_OF_MONTH));
        System.out.println(temporal.get(ChronoField.HOUR_OF_DAY));
        System.out.println(temporal.get(ChronoField.MINUTE_OF_HOUR));
        System.out.println(temporal.get(ChronoField.SECOND_OF_MINUTE));
        System.out.println(temporal.get(ChronoField.MILLI_OF_SECOND));
    }

    @Test
    void temporalQuery() {
        Temporal temporal = LocalDateTime.now();

        List<Integer> integers = temporal.query(new TemporalQuery<List<Integer>>() {
            @Override
            public List<Integer> queryFrom(TemporalAccessor temporal) {
                List<Integer> result = new ArrayList<>();

                result.add(temporal.get(ChronoField.YEAR));
                result.add(temporal.get(ChronoField.MONTH_OF_YEAR));
                result.add(temporal.get(ChronoField.DAY_OF_MONTH));
                result.add(temporal.get(ChronoField.HOUR_OF_DAY));
                result.add(temporal.get(ChronoField.MINUTE_OF_HOUR));
                result.add(temporal.get(ChronoField.SECOND_OF_MINUTE));

                return result;
            }
        });

        System.out.println(integers);
    }

    @Test
    void temporalAdjuster() {
        Temporal temporal1 = LocalDate.now();
        System.out.println(temporal1);

        Temporal temporal2 = temporal1.with(new TemporalAdjuster() {
            @Override
            public Temporal adjustInto(Temporal temporal) {
                return LocalDate.of(
                        temporal.get(ChronoField.YEAR),
                        temporal.get(ChronoField.MONTH_OF_YEAR),
                        1
                );
            }
        });

        Temporal temporal3 = temporal1.with(TemporalAdjusters.firstDayOfMonth());
        Temporal temporal4 = temporal1.with(TemporalAdjusters.lastDayOfMonth());

        System.out.println(temporal2);
        System.out.println(temporal3);
        System.out.println(temporal4);
    }
}
