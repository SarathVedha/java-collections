package com.vedha.collections.regex;

import java.util.regex.Pattern;

public class RegexDemo {

    // Check if the string contains only alphanumeric characters and space
    public static boolean isAlphanumericSpace(String value) {

        return !Pattern.compile("[!@#$%&*()^'\"/_+=|<>?{}\\[\\]~-]", Pattern.CASE_INSENSITIVE).matcher(value).find();
    }

    // Check if the string contains only alphanumeric characters, Arabic characters and space
    public static boolean isAlphaNumericArabicSpace(String value) {

        return Pattern.compile("^[a-zA-Z0-9\\u0600-\\u06FF\\s]+$", Pattern.CASE_INSENSITIVE).matcher(value).find();
    }


    public static void main(String[] args) {

        System.out.println(isAlphanumericSpace("1test لاترلاصر محضؤ ؤضحهبىةسسش")); // true

        System.out.println(isAlphaNumericArabicSpace( "1test يسي")); // true
    }
}
