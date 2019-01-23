package com.youlow;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class FractionTest {

    @Test(expected = ArithmeticException.class)
    public void ConstructorThrowArithmeticException() {
        Fraction f = new Fraction(1, 0);
    }

    @Test
    public void createdFractionNotNull() {
        Fraction f = new Fraction(1, 2);
        assertNotNull(f);
    }

    @Test
    public void getNumeratorEqualToNumerator() {
        Fraction f = new Fraction(5, 7);
        assertEquals(5, f.getNumerator());

    }

    @Test
    public void getDenominatorEqualToDenominator() {
        Fraction f = new Fraction(5, 7);
        assertEquals(7, f.getDenominator());
    }

    @Test
    public void createdFractionNegativeOnlyNumerator() {
        Fraction f1 = new Fraction(5, -7);
        assertEquals(-5, f1.getNumerator());
        assertEquals(7, f1.getDenominator());
        Fraction f2 = new Fraction(-3, 5);
        assertEquals(-3, f2.getNumerator());
        assertEquals(5, f2.getDenominator());
        Fraction f3 = new Fraction(-2, -5);
        assertEquals(2, f3.getNumerator());
        assertEquals(5, f3.getDenominator());
    }

    @Test
    public void createdFractionReduced(){
        Fraction f = new Fraction(4, 6);
        assertEquals(2, f.getNumerator());
        assertEquals(3, f.getDenominator());
    }

    @Test
    public void testPlusOperation() {
        Fraction f1 = new Fraction(2, 5);
        Fraction f2 = new Fraction(7, 15);
        Fraction res = f1.plus(f2);
        assertEquals(13, res.getNumerator());
        assertEquals(15, res.getDenominator());
    }

    @Test
    public void testMinusOperation() {
        Fraction f1 = new Fraction(7, 16);
        Fraction f2 = new Fraction(3, 8);
        Fraction res = f1.minus(f2);
        assertEquals(1, res.getNumerator());
        assertEquals(16, res.getDenominator());
    }

    @Test
    public void testMultiplyOperation() {
        Fraction f1 = new Fraction(3, 5);
        Fraction f2 = new Fraction(5, 7);
        Fraction res = f1.multiply(f2);
        assertEquals(3, res.getNumerator());
        assertEquals(7, res.getDenominator());
    }

    @Test
    public void testDivideOperation() {
        Fraction f1 = new Fraction(2, 5);
        Fraction f2 = new Fraction(3, 8);
        Fraction res = f1.divide(f2);
        assertEquals(16, res.getNumerator());
        assertEquals(15, res.getDenominator());
    }

    @Test(expected = ArithmeticException.class)
    public void testDivideException() {
        Fraction f1 = new Fraction(2, 5);
        Fraction f2 = new Fraction(0, 15);
        Fraction res = f1.divide(f2);
    }

    @Test
    public void testToStringOpetator() {
        Fraction f1 = new Fraction(0, 5);
        Fraction f2 = new Fraction(3, 8);
        assertEquals("0", f1.toString());
        assertEquals("3/8", f2.toString());
    }

}