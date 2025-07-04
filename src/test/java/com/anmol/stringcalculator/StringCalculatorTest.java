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

    @Test
    public void testMultipleCommaSeparatedNumbersReturnSum() {
        assertEquals(6, calculator.add("1,2,3"));
        assertEquals(15, calculator.add("1,2,3,4,5"));
        assertEquals(0, calculator.add("0,0,0"));
    }

    @Test
    public void testCommaAndNewlineAsDelimiters() {
        assertEquals(6, calculator.add("1\n2,3"));
        assertEquals(10, calculator.add("2,3\n5"));
        assertEquals(15, calculator.add("1\n2,3\n4,5"));
    }

}