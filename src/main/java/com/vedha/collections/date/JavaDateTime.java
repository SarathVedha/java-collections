package com.vedha.collections.date;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class JavaDateTime {

    public static void main(String[] args) {

        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println("Current Date and Time: " + currentDateTime); // Current Date and Time: 2021-07-25T12:00:00.000

        LocalDateTime plusDays = currentDateTime.plusDays(10);
        System.out.println("plusDays Date and Time: " + plusDays); // plusDays Date and Time: 2021-08-04T12:00:00
        LocalDateTime minusDays = currentDateTime.minusDays(10);
        System.out.println("minusDays Date and Time: " + minusDays); // minusDays Date and Time: 2021-07-15T12:00:00

        LocalDateTime plusWeeks = currentDateTime.plusWeeks(2);
        System.out.println("plusWeeks: " + plusWeeks); // plusWeeks: 2021-08-08T12:00:00
        LocalDateTime minusWeeks = currentDateTime.minusWeeks(2);
        System.out.println("minusWeeks: " + minusWeeks); // minusWeeks: 2021-07-11T12:00:00

        LocalDateTime plusMonths = currentDateTime.plusMonths(2);
        System.out.println("plusMonths Month and Time: " + plusMonths); // plusMonths Month and Time: 2021-09-25T12:00:00
        LocalDateTime minusMonths = currentDateTime.minusMonths(2);
        System.out.println("minusMonths Month and Time: " + minusMonths); // minusMonths Month and Time: 2021-05-25T12:00:00

        LocalDateTime plusYears = currentDateTime.plusYears(2);
        System.out.println("plusYears Year and Time: " + plusYears); // plusYears Year and Time: 2023-07-25T12:00:00
        LocalDateTime minusYears = currentDateTime.minusYears(2);
        System.out.println("minusYears Year and Time: " + minusYears); // minusYears Year and Time: 2019-07-25T12:00:00

        LocalDateTime plusHours = currentDateTime.plusHours(2);
        System.out.println("plusHours: " + plusHours); // plusHours: 2021-07-25T14:00:00
        LocalDateTime minusHours = currentDateTime.minusHours(2);
        System.out.println("minusHours: " + minusHours); // minusHours: 2021-07-25T10:00:00

        LocalDateTime plusMinutes = currentDateTime.plusMinutes(30);
        System.out.println("plusMinutes: " + plusMinutes); // plusMinutes: 2021-07-25T12:30:00
        LocalDateTime minusMinutes = currentDateTime.minusMinutes(30);
        System.out.println("minusMinutes: " + minusMinutes); // minusMinutes: 2021-07-25T11:30:00

        LocalDateTime plusSeconds = currentDateTime.plusSeconds(30);
        System.out.println("plusSeconds: " + plusSeconds); // plusSeconds: 2021-07-25T12:00:30
        LocalDateTime minusSeconds = currentDateTime.minusSeconds(30);
        System.out.println("minusSeconds: " + minusSeconds); // minusSeconds: 2021-07-25T11:59:30

        LocalDateTime plusNanos = currentDateTime.plusNanos(1000000000);
        System.out.println("plusNanos: " + plusNanos); // plusNanos: 2021-07-25T12:00:01
        LocalDateTime minusNanos = currentDateTime.minusNanos(1000000000);
        System.out.println("minusNanos: " + minusNanos); // minusNanos: 2021-07-25T11:59:59

        System.out.println("Year: " + currentDateTime.getYear()); // Year: 2021
        System.out.println("Month: " + currentDateTime.getMonth()); // Month: JULY
        System.out.println("Day of Month: " + currentDateTime.getDayOfMonth()); // Day of Month: 25
        System.out.println("Day of Week: " + currentDateTime.getDayOfWeek()); // Day of Week: SUNDAY
        System.out.println("Day of Year: " + currentDateTime.getDayOfYear()); // Day of Year: 206
        System.out.println("Hour: " + currentDateTime.getHour()); // Hour: 12
        System.out.println("Minute: " + currentDateTime.getMinute()); // Minute: 0
        System.out.println("Second: " + currentDateTime.getSecond()); // Second: 0
        System.out.println("Nano: " + currentDateTime.getNano()); // Nano: 0

        LocalDateTime localDateTime = LocalDateTime.of(LocalDate.now(), LocalTime.now());
        System.out.println("Local Date and Time: " + localDateTime); // Local Date and Time: 2021-07-25T12:00:00

        LocalDateTime localDateTime3 = LocalDateTime.of(2021, 8, 25, 12, 0, 0, 100000000);
        System.out.println("Local Date and Time: " + localDateTime3); // Local Date and Time: 2021-08-25T12:00:00.100

        LocalDateTime localDateTime2 = LocalDateTime.of(2021, Month.AUGUST, 25, 12, 0, 0, 100000000);
        System.out.println("Local Date and Time: " + localDateTime2); // Local Date and Time: 2021-08-25T12:00:00.100

        LocalDateTime customDateTime = LocalDateTime.of(2021, 7, 25, 12, 0, 0);
        System.out.println("Custom Date and Time: " + customDateTime); // Custom Date and Time: 2021-07-25T12:00:00

        LocalDateTime localDateTime1 = LocalDateTime.of(2021, Month.AUGUST, 25, 12, 0, 0);
        System.out.println("Local Date and Time: " + localDateTime1); // Local Date and Time: 2021-08-25T12:00:00

        LocalDateTime localDateTime4 = LocalDateTime.of(2021, 8, 25, 12, 0);
        System.out.println("Local Date and Time: " + localDateTime4); // Local Date and Time: 2021-08-25T12:00

        LocalDateTime localDateTime5 = LocalDateTime.of(2021, Month.AUGUST, 25, 12, 0);
        System.out.println("Local Date and Time: " + localDateTime5); // Local Date and Time: 2021-08-25T12:00

        LocalDateTime parse = LocalDateTime.parse("2021-07-25T12:00:00");
        System.out.println("Parse Date and Time: " + parse); // Parse Date and Time: 2021-07-25T12:00

        boolean before = parse.isBefore(LocalDateTime.now());
        System.out.println("Is Before: " + before); // Is Before: true - 2021-07-25T12:00 is before 2024-04-14T18:58:49.542728300

        boolean after = parse.isAfter(LocalDateTime.now());
        System.out.println("Is After: " + after); // Is After: false - 2021-07-25T12:00 is not after 2024-04-14T18:58:49.542728300

        boolean equal = parse.isEqual(LocalDateTime.now());
        System.out.println("Is Equal: " + equal); // Is Equal: false - 2021-07-25T12:00 is not equal to 2024-04-14T18:58:49.542728300

        LocalDateTime parse4 = LocalDateTime.parse("25072021120000000", DateTimeFormatter.ofPattern("ddMMyyyyHHmmssSSS"));
        System.out.println("Parse Date and Time: " + parse4); // Parse Date and Time: 2021-07-25T12:00:00

        LocalDateTime parse1 = LocalDateTime.parse("25/07/2021 12:00:00", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        System.out.println("Parse Date and Time: " + parse1); // Parse Date and Time: 2021-07-25T12:00

        LocalDateTime parse2 = LocalDateTime.parse("25-Jul-2021 12:00:00", DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss"));
        System.out.println("Parse Date and Time: " + parse2); // Parse Date and Time: 2021-07-25T12:00

        LocalDateTime parse3 = LocalDateTime.parse("25-July-2021 12:00:00:000", DateTimeFormatter.ofPattern("dd-MMMM-yyyy HH:mm:ss:SSS"));
        System.out.println("Parse Date and Time: " + parse3); // Parse Date and Time: 2021-07-25T12:00:00

        String format = parse3.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss:SSS"));
        System.out.println("Format Date and Time: " + format); // Format Date and Time: 25/07/2021 12:00:00:000

        String format1 = parse3.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));
        System.out.println("Format Date and Time: " + format1); // Format Date and Time:Jul 25, 2021, 12:00:00 PM

        // ZoneId
        System.out.println("Available Zone Ids: " + ZoneId.getAvailableZoneIds());
        System.out.println("System Default Zone Id: " + ZoneId.systemDefault()); // System Default Zone Id: Asia/Kolkata

        LocalDateTime now = LocalDateTime.now(ZoneId.systemDefault());
        System.out.println("Current Date and Time: " + now); // Current Date and Time: 2021-07-25T12:00:00.000

        LocalDateTime now1 = LocalDateTime.now(ZoneId.of("America/New_York"));
        System.out.println("Current Date and Time: " + now1); // Current Date and Time: 2021-07-25T02:30:00.000

        LocalDateTime max = LocalDateTime.MAX;
        System.out.println("Max Date and Time: " + max); // Max Date and Time: +999999999-12-31T23:59:59.999999999

        LocalDateTime min = LocalDateTime.MIN;
        System.out.println("Min Date and Time: " + min); // Min Date and Time: -999999999-01-01T00:00

    }
}
