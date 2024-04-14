package com.vedha.collections.date;

import java.time.Duration;
import java.time.LocalTime;

public class JavaDuration {

    public static void main(String[] args) {

        LocalTime now = LocalTime.now();
        System.out.println("Current Time: " + now);

        LocalTime nowPlus = now.plusHours(2).plusMinutes(30);
        System.out.println("Time after 2 hours and 30 minutes: " + nowPlus);

        long seconds = Duration.between(now, nowPlus).getSeconds();
        System.out.println("Duration between two times in seconds: " + seconds);

    }
}
