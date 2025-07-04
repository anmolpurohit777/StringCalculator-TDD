package com.anmol.stringcalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {

    private int callCount = 0;

    public int add(String input) {
        callCount++;

        if (isEmpty(input)) return 0;

        String delimiterRegex = "[,\n]";

        if (hasCustomDelimiter(input)) {
            delimiterRegex = "[,\n]|" + extractCustomDelimiterRegex(input);
            input = removeDelimiterPrefix(input);
        }

        List<Integer> parsedNumbers = parseAndValidate(input, delimiterRegex);
        return calculateSum(parsedNumbers);
    }

    public int GetCalledCount() {
        return callCount;
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

    private List<Integer> parseAndValidate(String input, String delimiterRegex) {
        String[] tokens = input.split(delimiterRegex);
        List<Integer> numbers = new ArrayList<>();
        List<Integer> negatives = new ArrayList<>();

        for (String token : tokens) {
            if (!token.trim().isEmpty()) {
                int num = Integer.parseInt(token.trim());
                if (num < 0) negatives.add(num);
                numbers.add(num);
            }
        }

        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("Negatives not allowed: " +
                    negatives.stream()
                            .map(String::valueOf)
                            .collect(Collectors.joining(", ")));
        }

        return numbers;
    }

    private int calculateSum(List<Integer> numbers) {
        int sum = 0;
        for (int num : numbers) {
            if(num <= 1000)
                sum += num;
        }
        return sum;
    }

}
