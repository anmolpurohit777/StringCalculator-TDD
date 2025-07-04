package com.anmol.stringcalculator;

import java.util.regex.Pattern;

public class StringCalculator {

    public int add(String input) {

        if (isEmpty(input)) return 0;

        String delimiterRegex = "[,\n]";

        if (hasCustomDelimiter(input)) {
            delimiterRegex = "[,\n]|" + extractCustomDelimiterRegex(input);
            input = removeDelimiterPrefix(input);
        }

        return sumDelimited(input, delimiterRegex);
    }

    private boolean isEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }

    private boolean hasCustomDelimiter(String input) {
        return input.startsWith("//");
    }

    private String extractCustomDelimiterRegex(String input) {
        int newlineIndex = input.indexOf("\n");
        String delimiter = input.substring(2, newlineIndex);
        return Pattern.quote(delimiter);
    }

    private String removeDelimiterPrefix(String input) {
        return input.substring(input.indexOf("\n") + 1);
    }

    private int sumDelimited(String input, String delimiterRegex) {

        String[] tokens = input.split(delimiterRegex);
        int sum = 0;

        for (String token : tokens) {
            int number = Integer.parseInt(token.trim());
            if (number < 0) {
                throw new IllegalArgumentException("Negatives not allowed: " + number);
            }
            sum += number;
        }

        return sum;
    }

}
