package com.vedha.collections.enums;

// Enum with fields and methods
public enum SortField {

    ID("id"),
    NAME("name"),
    PHONE_NUMBER("phoneNumber"),

    AGE("age");

    SortField(String value) {
        this.databaseFieldName = value;
    }

    private final String databaseFieldName;

    public String getDatabaseFieldName() {
        return databaseFieldName;
    }
}
