package com.vedha.collections.date;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

public class JavaPeriod {

    public static void main(String[] args) {

        // Period class used for date based amount of time.
        LocalDate now = LocalDate.now();
        System.out.println("Now: " + now); // current date

        LocalDate plusDays = now.plusDays(5);
        System.out.println("Now + 5 days: " + plusDays); // 5 days from now

        int days = Period.between(now, plusDays).getDays();
        System.out.println("Days between now and now + 5 days: " + days); // 5

        LocalDate dob = LocalDate.of(2000, Month.APRIL, 12);
        System.out.println("DOB: " + dob); // date of birth

        // from 2010-01-15 to 2011-03-18 is one year, two months and three days.
        // startDateInclusive – the start date, inclusive, not null - parameter1
        // endDateExclusive – the end date, exclusive, not null - parameter2
        Period period = Period.between(dob, now);
        System.out.println("Age: " + period.getYears() + " years " + period.getMonths() + " months " + period.getDays() + " days"); // age

        int days1 = Period.between(now, dob).getDays(); // negative value
        System.out.println("Days between now and DOB: " + days1); // -7480
    }
}
