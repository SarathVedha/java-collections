package com.vedha.collections.regex;

import java.util.Arrays;
import java.util.StringTokenizer;
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

        boolean b = Pattern.compile("[^a-zA-Z0-9]").matcher(value).find();
        System.out.println(b); // Output: true (as there are special characters in the string space and comma)

        /**
         * Metacharacter	Description
         * |	Find a match for any one of the patterns separated by | as in: cat|dog|fish
         * .	Find just one instance of any character
         * ^	Finds a match as the beginning of a string as in: ^Hello
         * $	Finds a match at the end of the string as in: World$
         * \d	Find a digit
         * \D	Find a non-digit character
         * \s	Find a whitespace character
         * \S	Find a non-whitespace character
         * \w	Find a word character
         * \W	Find a non-word character
         * \n	Find a new line character
         * \t	Find a tab character
         * \b	Find a match at the beginning of a word like this: \bWORD, or at the end of a word like this: WORD\b
         * \r	Find a carriage return character
         * \f	Find a form feed character
         */

        String newString = "Hi 12, I am Vedha. I have 2 cats and 1 dog";
        Matcher matcher7 = Pattern.compile("cat|dog|fish").matcher(newString); // Find a match for any one of the patterns separated by | as in: cat|dog|fish
        while (matcher7.find()) { // Output: cat, dog (both cat and dog are found) like or condition

            System.out.println(matcher7.group() + " Found at: " + matcher7.start());
        }

        Matcher matcher8 = Pattern.compile(".").matcher(newString); // Find just one instance of any character
        while (matcher8.find()) { // Output: H, i, 1, 2, ,,  , I,  , a, m,  , V, e, d, h, a, .,  , I,  , h, a, v, e,  , 2,  , c, a, t, s,  , a, n, d,  , 1,  , d, o, g (all characters)

            System.out.println(matcher8.group() + " Found at: " + matcher8.start());
        }

        boolean b1 = Pattern.compile("^Hi").matcher(newString).find();// Find a match as the beginning of a string as in: ^Hello
        System.out.println(b1); // Output: true (as the string starts with Hi)

        boolean b2 = Pattern.compile("dog$").matcher(newString).find(); // Find a match at the end of the string as in: World$
        System.out.println(b2); // Output: true (as the string ends with dog)

        Matcher matcher9 = Pattern.compile("\\d").matcher(newString); // Find a digit
        while (matcher9.find()) { // Output: 1, 2, 2, 1 (all digits)

            System.out.println(matcher9.group() + " Found at: " + matcher9.start());
        }

        String x = "Hi i am 24 years old".replaceAll("\\d", "X");// Output: Hi an XX years old
        System.out.println(x);

        // only amount with 122.00 with XXX.XX format
        String y = "Hi i am 24 years old and I have 122.00 rupees".replaceAll("\\d{3}\\.\\d{2}", "XXX.XX");// Output: Hi i am 24 years old and I have XXX.XX rupees
        System.out.println(y);

        Matcher matcher12 = Pattern.compile("\\D").matcher(newString);// Find a non-digit character
        while (matcher12.find()) { // Output: H, i, ,,  , I,  , a, m,  , V, e, d, h, a, .,  , I,  , h, a, v, e,  , c, a, t, s,  , a, n, d,  , d, o, g (all non-digits)

            System.out.println(matcher12.group() + " Found at: " + matcher12.start());
        }

        Matcher matcher10 = Pattern.compile("\\s").matcher(newString); // Find a whitespace character
        while (matcher10.find()) { // Output: (all spaces)

            System.out.println(matcher10.group() + " Found at: " + matcher10.start());
        }

        Matcher matcher13 = Pattern.compile("\\S").matcher(newString); // Find a non-whitespace character
        while (matcher13.find()) { // Output: H, i, 1, 2, ,, I, a, m, V, e, d, h, a, I, h, a, v, e, 2, c, a, t, s, a, n, d, 1, d, o, g (all non-whitespace characters)

            System.out.println(matcher13.group() + " Found at: " + matcher13.start());
        }

        Matcher matcher11 = Pattern.compile("\\w").matcher(newString);// Find a word character
        while (matcher11.find()) { // Output: H, i, 1, 2, I, a, m, V, e, d, h, a, I, h, a, v, e, 2, c, a, t, s, a, n, d, 1, d, o, g (all word characters)

            System.out.println(matcher11.group() + " Found at: " + matcher11.start());
        }

        Matcher matcher14 = Pattern.compile("\\W").matcher(newString); // Find a non-word character
        while (matcher14.find()) { // Output: non-word characters like space, comma, dot (special characters)

            System.out.println(matcher14.group() + " Found at: " + matcher14.start());
        }

        Matcher matcher15 = Pattern.compile("\\ba").matcher(newString); // Find a match at the beginning of a word like this: \bWORD, or at the end of a word like this: WORD\b
        while (matcher15.find()) { // Output: a (only a at the beginning of the word) (am and) start with a

            System.out.println(matcher15.group() + " Found at: " + matcher15.start());
        }

        Matcher matcher16 = Pattern.compile("a\\b").matcher(newString); // Find a match at the beginning of a word like this: \bWORD, or at the end of a word like this: WORD\b
        while (matcher16.find()) { // Output: a (only a at the end of the word) (Vedha) end with a

            System.out.println(matcher16.group() + " Found at: " + matcher16.start());
        }

        // Find a new line character
        String newLine = "Hi\nI am Vedha";
        System.out.println(newLine);
        Matcher matcher17 = Pattern.compile("\\n").matcher(newLine); // Find a new line character
        while (matcher17.find()) { // Output: (new line character)

            System.out.println("New Line Found at: " + matcher17.start());
        }

        // Find a tab character
        String tab = "Hi\tI am Vedha";
        System.out.println(tab);
        Matcher matcher18 = Pattern.compile("\\t").matcher(tab); // Find a tab character
        while (matcher18.find()) { // Output: (tab character)

            System.out.println("Tab Found at: " + matcher18.start());
        }

        // Find a carriage return character
        String carriageReturn = "Hi\rI am Vedha";
        System.out.println(carriageReturn);
        Matcher matcher19 = Pattern.compile("\\r").matcher(carriageReturn); // Find a carriage return character
        while (matcher19.find()) { // Output: (carriage return character)

            System.out.println("Carriage Return Found at: " + matcher19.start());
        }

        // Find a form feed character
        String formFeed = "Hi\fI am Vedha";
        System.out.println(formFeed);
        Matcher matcher20 = Pattern.compile("\\f").matcher(formFeed); // Find a form feed character
        while (matcher20.find()) { // Output: (form feed character)

            System.out.println("Form Feed Found at: " + matcher20.start());
        }

        /**
         * Quantifier	Description
         * n+	Matches any string that contains at least one n
         * n*	Matches any string that contains zero or more occurrences of n
         * n?	Matches any string that contains zero or one occurrences of n
         * n{x}	Matches any string that contains a sequence of X n's
         * n{x,y}	Matches any string that contains a sequence of X to Y n's
         * n{x,}	Matches any string that contains a sequence of at least X n's
         */

        String newString1 = "I am Vedha";
        Matcher matcher21 = Pattern.compile("a+").matcher(newString1); // Matches any string that contains at least one a
        while (matcher21.find()) { // Output: a (only one a is found)

            System.out.println(matcher21.group() + " Found at: " + matcher21.start());
        }

        Matcher matcher22 = Pattern.compile("a*").matcher(newString1); // Matches any string that contains zero or more occurrences of a
        while (matcher22.find()) { // Output: (empty string), a,.... (all occurrences of a)

            System.out.println(matcher22.group() + " Found at: " + matcher22.start());
        }

        Matcher matcher23 = Pattern.compile("a?").matcher(newString1); // Matches any string that contains zero or one occurrences of a
        while (matcher23.find()) { // Output: (empty string), a,.... (all occurrences of a)

            System.out.println(matcher23.group() + " Found at: " + matcher23.start());
        }

        System.out.println("**********");
        String newString2 = "aabbaaabbaaaba";
        Matcher matcher24 = Pattern.compile("a{2}").matcher(newString2); // Matches any string that contains a sequence of 2 a's
        while (matcher24.find()) { // Output: aa, aa, aa (all occurrences of 2 a's)

            System.out.println(matcher24.group() + " Found at: " + matcher24.start());
        }

        System.out.println("**********");
        Matcher matcher25 = Pattern.compile("a{2,3}").matcher(newString2); // Matches any string that contains a sequence of 2 to 3 a's
        while (matcher25.find()) { // Output: aa, aa, aa, aa, aa (all occurrences of 2 to 3 a's)

            System.out.println(matcher25.group() + " Found at: " + matcher25.start());
        }

        System.out.println("**********");
        Matcher matcher26 = Pattern.compile("a{1,}").matcher(newString2); // Matches any string that contains a sequence of at least 2 a's
        while (matcher26.find()) { // Output: aa, aa, aa, aa, aa (all occurrences of at least 2 a's)

            System.out.println(matcher26.group() + " Found at: " + matcher26.start());
        }

        System.out.println("**********");
        String newString3 = "I am Vedha. I have 2 cats and 1 dog";

        // Split the string based on space
        System.out.println(Arrays.toString(newString3.split("\\s")));

        // Split the string based on dot
        System.out.println(Arrays.toString(newString3.split("\\.")));

        System.out.println(Arrays.toString(newString3.split("\\d"))); // Split the string based on digits

        System.out.println(newString3.replaceAll("\\d", "X")); // Replace all digits with X

        System.out.println(newString3.replaceAll("\\D", "X")); // Replace all non-digits with X

        System.out.println(newString3.replaceAll("\\s", "-")); // Replace all whitespaces with '-'

        System.out.println("*************");

        // StringTokenizer is a legacy class that is retained for compatibility reasons although its use is discouraged in new code.
        // It is recommended to use the split() method of String or the java.util.regex package instead.
        // StringTokenizer is used to break a string into tokens.

        String newString4 = "I am Vedha.";
        StringTokenizer stringTokenizer = new StringTokenizer(newString4); // default delimiter is space
        System.out.println(stringTokenizer.countTokens()); // Output: 3
        while (stringTokenizer.hasMoreTokens()) {

            System.out.println(stringTokenizer.nextToken());
        }

        StringTokenizer stringTokenizer1 = new StringTokenizer(newString4, "a"); // delimiter is 'a'
        System.out.println(stringTokenizer1.countTokens()); // Output: 2
        while (stringTokenizer1.hasMoreTokens()) {

            System.out.println(stringTokenizer1.nextToken());
        }

        String newString5 = "https://www.vedha.com";
        StringTokenizer stringTokenizer2 = new StringTokenizer(newString5, "."); // delimiter is '.'
        System.out.println(stringTokenizer2.countTokens()); // Output: 3
        while (stringTokenizer2.hasMoreTokens()) {

            System.out.println(stringTokenizer2.nextToken());
        }

        // Output: https, www, vedha, com
        String[] split = newString5.split("\\.|:|//"); // Split the string based on . or : or // using | operator
        System.out.println(Arrays.toString(split));

        // Regex
        // checks the string is valid mobile number or not
        String mobileNumber = "91-9234567890";
        System.out.println(mobileNumber.matches("(0|91-)?[6-9]\\d{9}")); // Output: true

    }
}
