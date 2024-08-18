package com.vedha.collections.regex;

import java.util.regex.Pattern;

public class RegexExample {

    // Check if the string contains only alphanumeric characters and space
    public static boolean isSpecialChars(String value) {

        return Pattern.compile("[!@#$%&*()^'\"/_+=|<>?{}\\[\\]~-]", Pattern.CASE_INSENSITIVE).matcher(value).find();
    }

    // Check if the string contains only alphanumeric characters, Arabic characters and space
    public static boolean isAlphaNumericArabicSpace(String value) {

        return Pattern.compile("^[a-zA-Z0-9\\u0600-\\u06FF\\s]+$", Pattern.CASE_INSENSITIVE).matcher(value).find();
    }

    // write a code to check sql injection
    public static boolean isSqlInjection(String value) {

        return Pattern.compile(".*((\\b(ALTER|CREATE|DELETE|DROP|EXEC|INSERT|SELECT|UPDATE|UNION)\\b)|(\\b(\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3})\\b)).*", Pattern.CASE_INSENSITIVE).matcher(value).find();
    }

    public static boolean isXssOptimized(String value) {

        if (value != null) {

            if (Pattern.compile(".*[#!{}'%^()<>\"].*").matcher(value).find())
                return true;
            if (Pattern.compile(".*http://.*").matcher(value).find())
                return true;
            if (Pattern.compile(".*<img.*").matcher(value).find())
                return true;
            if (Pattern.compile(".*</img.*").matcher(value).find())
                return true;
            if (Pattern.compile("&#", Pattern.CASE_INSENSITIVE).matcher(value).find())
                return true;
            if (Pattern.compile("<script>(.*?)</script>", Pattern.CASE_INSENSITIVE).matcher(value).find())
                return true;
            if (Pattern.compile("src[\r\n]=[\r\n]'(.*?)'", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL).matcher(value).find())
                return true;
            if (Pattern.compile("src[\r\n]=[\r\n]\"(.*?)\"", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL).matcher(value).find())
                return true;
            if (Pattern.compile("src/(.*?)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL).matcher(value).find())
                return true;
            if (Pattern.compile("onerror=", Pattern.CASE_INSENSITIVE).matcher(value).find())
                return true;
            if (Pattern.compile("onerror=(.*?)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL).matcher(value).find())
                return true;
            if (Pattern.compile("</script>", Pattern.CASE_INSENSITIVE).matcher(value).find())
                return true;
            if (Pattern.compile("<script(.*?)>", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL).matcher(value).find())
                return true;
            if (Pattern.compile("eval\\((.*?)\\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL).matcher(value).find())
                return true;
            if (Pattern.compile("expression\\((.*?)\\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL).matcher(value).find())
                return true;
            if (Pattern.compile("javascript:", Pattern.CASE_INSENSITIVE).matcher(value).find())
                return true;
            if (Pattern.compile("vbscript:", Pattern.CASE_INSENSITIVE).matcher(value).find())
                return true;
            if (Pattern.compile("onload(.*?)=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL).matcher(value).find())
                return true;
            return Pattern.compile("DllImport", Pattern.CASE_INSENSITIVE).matcher(value).find();
        }

        return false;
    }

    public static void main(String[] args) {

        System.out.println(isSpecialChars("1test لاترلاصر محضؤ ؤضحهبىةسسش")); // false

        System.out.println(isSpecialChars("@1test لاترلاصر محضؤ ؤضحهبىةسسش")); // true

        System.out.println(isAlphaNumericArabicSpace( "1test يسيضصثقفغعهخحشسيبلاتنمئؤرلاىةوزو")); // true

        System.out.println(isAlphaNumericArabicSpace( "@1test يسيضصثقفغعهخحشسيبلاتنمئؤرلاىةوزو")); // false

        System.out.println(isSqlInjection( "1test")); // false

        System.out.println(isSqlInjection( "1test SELECT * from test")); // true

        System.out.println(isXssOptimized( "1test")); // false

        System.out.println(isXssOptimized( "1test <script>alert('test')</script>")); // true
    }
}
