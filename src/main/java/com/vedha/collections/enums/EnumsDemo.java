package com.vedha.collections.enums;

import org.springframework.http.HttpStatus;

public class EnumsDemo {

    public static void main(String[] args) {

        Enums sunday = Enums.SUNDAY;
        System.out.println("Day Sun: " + sunday);

        Object sunday2 = Enums.SUNDAY.getDayValue();
        System.out.println("Day Sun: " + sunday2);

        Object dayValue1 = Enums.MONDAY.getDayValue();
        System.out.println("Day Mon: " + dayValue1);

        String dayTues = Enums.TUESDAY.name();
        System.out.println("Day Tue: " + dayTues);

        String name = SortField.NAME.name();
        System.out.println("name: " + name);

        String databaseFieldName = SortField.PHONE_NUMBER.getDatabaseFieldName();
        System.out.println("databaseFieldName: " + databaseFieldName);

        String databaseFieldName1 = SortField.AGE.getDatabaseFieldName();
        System.out.println("databaseFieldName1: " + databaseFieldName1);

        int value = HttpStatus.BAD_REQUEST.value();
        System.out.println("value: " + value);
    }
}
