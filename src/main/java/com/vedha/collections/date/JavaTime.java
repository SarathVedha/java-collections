package com.vedha.collections.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class JavaTime {

    public static void main(String[] args) {

        LocalTime time = LocalTime.now();
        System.out.println("Current Time: " + time); // Current Time: 10:15:30.123456789

        LocalTime plusHours = time.plusHours(2);
        System.out.println("plusHours Time: " + plusHours);
        LocalTime minusHours = time.minusHours(2);
        System.out.println("minusHours Time: " + minusHours);

        LocalTime plusMinutes = time.plusMinutes(30);
        System.out.println("plusMinutes Time: " + plusMinutes);
        LocalTime minusMinutes = time.minusMinutes(30);
        System.out.println("minusMinutes Time: " + minusMinutes);

        LocalTime plusSeconds = time.plusSeconds(20);
        System.out.println("plusSeconds Time: " + plusSeconds);
        LocalTime minusSeconds = time.minusSeconds(20);
        System.out.println("minusSeconds Time: " + minusSeconds);

        LocalTime plusNanos = time.plusNanos(40);
        System.out.println("plusNanos Time: " + plusNanos);
        LocalTime minusNanos = time.minusNanos(40);
        System.out.println("minusNanos Time: " + minusNanos);

        System.out.println("Hour: " + time.getHour()); // Hour: 10
        System.out.println("Minute: " + time.getMinute()); // Minute: 15
        System.out.println("Second: " + time.getSecond()); // Second: 30
        System.out.println("Nano: " + time.getNano()); // Nano: 123456789

        LocalTime localTime1 = LocalTime.of(12, 20);
        System.out.println("Local Time: " + localTime1); // Local Time: 12:20

        LocalTime localTime = LocalTime.of(12, 20, 25);
        System.out.println("Local Time: " + localTime); // Local Time: 12:20:25

        LocalTime specificTime = LocalTime.of(12, 20, 25, 40);
        System.out.println("Specific Time of Day: " + specificTime); // Specific Time of Day: 12:20:25.000000040

        LocalTime parse = LocalTime.parse("12:20:25");
        System.out.println("Parse Time: " + parse); // Parse Time: 12:20:25

        boolean before = parse.isBefore(LocalTime.now());
        System.out.println("Is Before: " + before); // Is Before: true - 12:20:25 is before 18:29:52.614047600

        boolean after = parse.isAfter(LocalTime.now());
        System.out.println("Is After: " + after); // Is After: false - 12:20:25 is not after 18:29:52.614047600

        boolean equal = parse.equals(LocalTime.now());
        System.out.println("Is Equal: " + equal); // Is Equal: false - 12:20:25 is not equal to 18:29:52.614047600

        LocalTime parse1 = LocalTime.parse("12:20:25.123456789");
        System.out.println("Parse Time: " + parse1); // Parse Time: 12:20:25.123456789

        LocalTime parse2 = LocalTime.parse("122025", DateTimeFormatter.ofPattern("HHmmss"));
        System.out.println("Parse Time: " + parse2); // Parse Time: 12:20:25

        LocalTime parse3 = LocalTime.parse("12-20-25", DateTimeFormatter.ofPattern("HH-mm-ss"));
        System.out.println("Parse Time: " + parse3); // Parse Time: 12:20:25

        LocalTime parse4 = LocalTime.parse("12:20:25", DateTimeFormatter.ofPattern("HH:mm:ss"));
        System.out.println("Parse Time: " + parse4); // Parse Time: 12:20:25

        LocalTime parse6 = LocalTime.parse("12:20:25:401", DateTimeFormatter.ofPattern("HH:mm:ss:SSS"));
        System.out.println("Parse Time: " + parse6); // Parse Time: 12:20:25.000000401

        LocalTime parse5 = LocalTime.parse("12:20:25:123456789", DateTimeFormatter.ofPattern("HH:mm:ss:nnnnnnnnn"));
        System.out.println("Parse Time: " + parse5); // Parse Time: 12:20:25.123456789

        String format = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));// 18:29:52
        System.out.println("Format Time: " + format);

        // ZoneId
        System.out.println("All ZoneIds: " + ZoneId.getAvailableZoneIds());
        System.out.println("System Default ZoneId: " + ZoneId.systemDefault()); // System Default ZoneId: Asia/Kolkata

        LocalTime now = LocalTime.now(ZoneId.systemDefault());
        System.out.println("Now Time: " + now); // Now Time: 18:29:52.614047600

        LocalTime now1 = LocalTime.now(ZoneId.of("America/New_York")); // America/New_York time
        System.out.println("Now Time: " + now1); // Now Time: 08:59:52.614047600

        LocalTime max = LocalTime.MAX;
        System.out.println("Max Time: " + max); // Max Time: 23:59:59.999999999

        LocalTime min = LocalTime.MIN;
        System.out.println("Min Time: " + min); // Min Time: 00:00

        LocalTime midnight = LocalTime.MIDNIGHT;
        System.out.println("Midnight Time: " + midnight); // Midnight Time: 00:00

        LocalTime noon = LocalTime.NOON;
        System.out.println("Noon Time: " + noon); // Noon Time: 12:00

        LocalDateTime localDateTime = localTime.atDate(LocalDate.now());
        System.out.println("Local Date Time: " + localDateTime); // Local Date Time: 2020-07-15T12:20:25

    }
}

