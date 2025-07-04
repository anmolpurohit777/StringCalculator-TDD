package com.anmol.stringcalculator;

public class StringCalculator {

    public int add(String input) {

        if (isEmpty(input)) return 0;
        if (isSingleNumber(input)) return parseSingleNumber(input);
        if (isCommaSeparated(input)) return sumCommaSeparated(input);

        return -1;
    }

    private boolean isEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }

    private boolean isSingleNumber(String input) {
        return !input.contains(",") && !input.contains("\n");
    }

    private boolean isCommaSeparated(String input) {
        return input.contains(",") && !input.contains("\n");
    }

    private int parseSingleNumber(String input) {
        return Integer.parseInt(input.trim());
    }

    private int sumCommaSeparated(String input) {
        String[] tokens = input.split(",");
        int sum = 0;
        for (String token : tokens) {
            sum += Integer.parseInt(token.trim());
        }
        return sum;
    }

}
