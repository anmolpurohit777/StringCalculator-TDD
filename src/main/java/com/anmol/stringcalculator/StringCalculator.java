package com.anmol.stringcalculator;

import java.util.regex.Pattern;

public class StringCalculator {

    public int add(String input) {

        if (isEmpty(input)) return 0;
        if (isSingleNumber(input)) return parseSingleNumber(input);
        if (isCommaOnly(input)) return sumDelimited(input, ",");

        return -1;
    }

    private boolean isEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }

    private boolean isSingleNumber(String input) {
        return !input.contains(",") && !input.contains("\n");
    }

    private boolean isCommaOnly(String input) {
        return input.contains(",") && !input.contains("\n");
    }

    private int parseSingleNumber(String input) {
        return Integer.parseInt(input.trim());
    }

    private int sumDelimited(String input, String delimiter) {

        String[] tokens = input.split(Pattern.quote(delimiter));
        int sum = 0;

        for (String token : tokens) {
            sum += Integer.parseInt(token.trim());
        }

        return sum;
    }

}
