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

    @Test
    public void testCustomDelimiter() {
        assertEquals(3, calculator.add("//;\n1;2"));
        assertEquals(6, calculator.add("//#\n2#2#2"));
        assertEquals(10, calculator.add("//.\n1.2,3\n4"));
    }

    @Test
    public void testSingleNegativeThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                calculator.add("1,-3,2"));

        assertEquals("Negatives not allowed: -3", exception.getMessage());
    }

    @Test
    public void testMultipleNegativesThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                calculator.add("2,-5,-7"));

        assertEquals("Negatives not allowed: -5, -7", exception.getMessage());
    }

    @Test
    public void testGetCalledCount() {
        calculator.add("1,2");
        calculator.add("3,4,5");

        assertEquals(2, calculator.GetCalledCount());
    }

    @Test
    public void testNumbersGreaterThan1000AreIgnored() {
        assertEquals(2, calculator.add("2,1001"));
        assertEquals(1002, calculator.add("2,1000"));
        assertEquals(6, calculator.add("//;\n1;1002;2;3;1200"));
        assertEquals(1006, calculator.add("//;\n1;1000,2\n3;1010"));
    }

}