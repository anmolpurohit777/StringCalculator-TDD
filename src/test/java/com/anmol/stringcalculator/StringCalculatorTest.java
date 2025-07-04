package com.anmol.stringcalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    private StringCalculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new StringCalculator();
    }

    @Test
    public void testEmptyStringReturnsZero() {
        assertEquals(0, calculator.add(""));
    }

    @Test
    public void testSingleNumberReturnsValue() {
        assertEquals(5, calculator.add("5"));
        assertEquals(100, calculator.add("100"));
    }

    @Test
    public void testTwoCommaSeparatedNumbersReturnSum() {
        assertEquals(3, calculator.add("1,2"));
        assertEquals(100, calculator.add("40,60"));
    }

}