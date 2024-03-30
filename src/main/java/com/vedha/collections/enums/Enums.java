package com.vedha.collections.enums;

// Enum with fields and methods
public enum Enums {

    // Enum with constructor
    SUNDAY("Sunday is Holiday"),
    MONDAY(1),
    TUESDAY("Week 2 day"),
    WEDNESDAY(3),
    THURSDAY(4),
    FRIDAY(5),
    SATURDAY(6);

    Enums(Object value) {

        dayValue = value;
    }

    private final Object dayValue;

    public Object getDayValue() {
        return dayValue;
    }
}

