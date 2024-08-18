package com.vedha.collections.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo {

    public static void main(String[] args) {

        // Regex contains Pattern and Matcher classes to work with regular expressions.
        // Pattern class is used to define the pattern that can be used for searching or manipulating string.
        // Matcher class is used to match the pattern against the string and perform matching operations like search,
        // replace, etc.

        String value = "Hi 12, I am Vedha"; // String to be matched
        Pattern pattern = Pattern.compile("Vedha"); // Pattern class is used to define the pattern
        Matcher matcher = pattern.matcher(value); // Matcher class is used to match the pattern against the string
//        System.out.println(matcher.find()); // Output: true

        while (matcher.find()) {
            System.out.println(matcher.group() + " Found at: " + matcher.start() + " - " + matcher.end());
        }

        // ^ and $ are used to match the beginning and end of the string respectively.
        if (Pattern.compile("^Vedha").matcher(value).find()) {

            System.out.println("String starts with Vedha");
        }

        if (Pattern.compile("Vedha$").matcher(value).find()) {

            System.out.println("String ends with Vedha");
        }

        /**
         * Expression	Description
         * [abc]    Find one character from the options between the brackets
         * [^abc]   Find one character NOT between the brackets
         * [0-9]	Find one character from the range 0 to 9
         */

        // Find one character from the options between the brackets
        Matcher matcher1 = Pattern.compile("[abcd]").matcher(value); // Find one character from the options between the brackets
        while (matcher1.find()) {

            System.out.println(matcher1.group() + " Found at: " + matcher1.start());
        }

        // Find one character NOT between the brackets
        Matcher matcher2 = Pattern.compile("[^abcd]").matcher(value); // Find one character NOT between the brackets
        while (matcher2.find()) { // Output: H, i, , I,  , m,  , V, e, h (all characters except a, b, c, d)

            System.out.println(matcher2.group() + " Found at: " + matcher2.start());
        }

        // Find one character from the range a to z
        Matcher matcher3 = Pattern.compile("[a-z]").matcher(value); // Find one character from the range a to z
        while (matcher3.find()) { // Output: i, a, m, e, d, h, a (all lower characters)

            System.out.println(matcher3.group() + " Found at: " + matcher3.start());
        }

        // Find one character from the range a to z and A to Z
        Matcher matcher4 = Pattern.compile("[a-zA-Z]").matcher(value); // Find one character from the range a to z and A to Z
        while (matcher4.find()) { // Output: H, i, I, m, V, e, d, h, a (all characters)

            System.out.println(matcher4.group() + " Found at: " + matcher4.start());
        }

        // Find one character from the range 0 to 9
        Matcher matcher5 = Pattern.compile("[0-9]").matcher(value); // Find one character from the range 0 to 9
        while (matcher5.find()) { // Output: 1, 2 (only one digit)

            System.out.println(matcher5.group() + " Found at: " + matcher5.start());
        }

        // Only Special Characters
        Matcher matcher6 = Pattern.compile("[^a-zA-Z0-9]").matcher(value); // Find one character NOT between the brackets
        while (matcher6.find()) { // Output: , , , , , , , , , (all special characters) including space

                System.out.println(matcher6.group() + " Found at: " + matcher6.start());
        }

        /**
         * Metacharacter	Description
         * |	Find a match for any one of the patterns separated by | as in: cat|dog|fish
         * .	Find just one instance of any character
         * ^	Finds a match as the beginning of a string as in: ^Hello
         * $	Finds a match at the end of the string as in: World$
         * \d	Find a digit
         * \s	Find a whitespace character
         * \b	Find a match at the beginning of a word like this: \bWORD, or at the end of a word like this: WORD\b
         */

        /**
         * Quantifier	Description
         * n+	Matches any string that contains at least one n
         * n*	Matches any string that contains zero or more occurrences of n
         * n?	Matches any string that contains zero or one occurrences of n
         * n{x}	Matches any string that contains a sequence of X n's
         * n{x,y}	Matches any string that contains a sequence of X to Y n's
         * n{x,}	Matches any string that contains a sequence of at least X n's
         */
    }
}
