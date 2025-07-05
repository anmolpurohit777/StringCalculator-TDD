package com.anmol.stringcalculator;

import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class StringCalculator {

    private int callCount = 0;

    public int add(String input) {
        callCount++;

        if (isEmpty(input)) return 0;

        String delimiterRegex = "[,\n]";

        if (hasCustomDelimiter(input)) {
            delimiterRegex = "[,\n]|" + extractDelimiters(input);
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

    private String extractDelimiters(String input) {
        int newlineIndex = input.indexOf("\n");
        String delimiterSection = input.substring(2, newlineIndex);

        if (!delimiterSection.startsWith("[")) {
                return Pattern.quote(delimiterSection);
        }

        Matcher matcher = Pattern.compile("\\[(.*?)]").matcher(delimiterSection);
        List<String> delimiters = new ArrayList<>();
        while (matcher.find()) {
            delimiters.add(matcher.group(1));
        }

        if (delimiters.size() == 1) {
            return Pattern.quote(delimiters.get(0));
        }

        return delimiters.stream()
                .filter(d -> d.length() == 1)
                .map(Pattern::quote)
                .collect(Collectors.joining("|"));
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
