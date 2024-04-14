package com.vedha.collections.date;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Set;

public class JavaDate {

    public static void main(String[] args) {

        LocalDate date = LocalDate.now();
        System.out.println("Current Date: " + date); // Current Date: 2021-07-12

        LocalDate plusDays = date.plusDays(10);
        System.out.println("plusDays Date: " + plusDays);
        LocalDate minusDays = date.minusDays(10);
        System.out.println("minusDays Date: " + minusDays);

        LocalDate plusMonths = date.plusMonths(2);
        System.out.println("plusMonths Month: " + plusMonths);
        LocalDate minusMonths = date.minusMonths(2);
        System.out.println("minusMonths Month: " + minusMonths);

        LocalDate plusYears = date.plusYears(2);
        System.out.println("plusYears Year: " + plusYears);
        LocalDate minusYears = date.minusYears(2);
        System.out.println("minusYears Year: " + minusYears);

        System.out.println("Year: " + date.getYear()); // Year: 2021
        System.out.println("Month: " + date.getMonth()); // Month: JULY
        System.out.println("Day of Month: " + date.getDayOfMonth()); // Day of Month: 12
        System.out.println("Day of Week: " + date.getDayOfWeek()); // Day of Week: MONDAY
        System.out.println("Day of Year: " + date.getDayOfYear()); // Day of Year: 193
        System.out.println("Is Leap Year: " + date.isLeapYear()); // Is Leap Year: false

        LocalDate dob = LocalDate.of(2000, 4, 12);
        System.out.println("Date of Birth: " + dob); // Date of Birth: 2000-04-12

        LocalDate localDate = LocalDate.of(2000, Month.APRIL, 12);
        System.out.println("Local Date: " + localDate); // Local Date: 2000-04-12

        LocalDate customDate = LocalDate.parse("2020-12-12");
        System.out.println("Custom Date: " + customDate); // Custom Date: 2020-12-12

        boolean after = dob.isAfter(customDate); // false - 2000-04-12 is not after 2020-12-12
        System.out.println("Is After: " + after);

        boolean before = dob.isBefore(customDate); // true - 2000-04-12 is before 2020-12-12
        System.out.println("Is Before: " + before);

        boolean equal = dob.isEqual(customDate); // false - 2000-04-12 is not equal to 2020-12-12
        System.out.println("Is Equal: " + equal);

        LocalDate parse = LocalDate.parse("12/04/2000", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.println("Parse Date: " + parse);

        LocalDate parse1 = LocalDate.parse("12-Apr-2000", DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
        System.out.println("Parse Date: " + parse1);

        LocalDate parse2 = LocalDate.parse("12-April-2000", DateTimeFormatter.ofPattern("dd-MMMM-yyyy"));
        System.out.println("Parse Date: " + parse2);

        LocalDate parse3 = LocalDate.parse("12042000", DateTimeFormatter.ofPattern("ddMMyyyy"));
        System.out.println("Parse Date: " + parse3);

        String format = parse3.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.println("Format Date: " + format);

        // ZoneId
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        System.out.println("Available Zone Ids: " + availableZoneIds);

        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println("Zone Id: " + zoneId); // Asia/Kolkata

        LocalDate now = LocalDate.now(ZoneId.of("Asia/Kolkata"));
        System.out.println("Now Date: " + now);

        LocalDate now2 = LocalDate.now(ZoneId.systemDefault());
        System.out.println("Now Date: " + now2);

        LocalDate now1 = LocalDate.now(ZoneId.of("America/New_York")); // America/New_York date
        System.out.println("Now Date: " + now1);

        LocalDate min = LocalDate.MIN;
        System.out.println("Min Date: " + min); // -999999999-01-01

        LocalDate max = LocalDate.MAX;
        System.out.println("Max Date: " + max); // +999999999-12-31

        LocalDate epoch = LocalDate.EPOCH;
        System.out.println("Epoch Date: " + epoch); // 1970-01-01
    }
}
