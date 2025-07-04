package com.anmol.stringcalculator;

import java.util.regex.Pattern;

public class StringCalculator {

    public int add(String input) {

        if (isEmpty(input)) return 0;
        if (isSingleNumber(input)) return parseSingleNumber(input);
        if (containsCommaOrNewline(input)) return sumDelimited(input, "[,\n]");

        return -1;
    }

    private boolean isEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }

    private boolean isSingleNumber(String input) {
        return !input.contains(",") && !input.contains("\n");
    }

    private boolean containsCommaOrNewline(String input) {
        return input.contains(",") || input.contains("\n");
    }

    private int parseSingleNumber(String input) {
        return Integer.parseInt(input.trim());
    }

    private int sumDelimited(String input, String delimiterRegex) {

        String[] tokens = input.split(delimiterRegex);
        int sum = 0;

        for (String token : tokens) {
            sum += Integer.parseInt(token.trim());
        }

        return sum;
    }

}
