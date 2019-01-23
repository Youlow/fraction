package com.youlow;

import java.math.BigInteger;

public class Fraction implements IFraction{

    private long numerator;
    private long denominator;

    public Fraction(long numerator, long denominator) {
        if(denominator == 0) {
            throw new ArithmeticException("Denominator of the fraction can't be zero!");
        } else if (denominator < 0) {
            denominator = -denominator;
            numerator = -numerator;
        }
        long gcd = gcd(numerator, denominator);
        this.numerator = numerator / gcd;
        this.denominator = denominator / gcd;
    }

    public long getNumerator() {
        return numerator;
    }

    public long getDenominator() {
        return denominator;
    }

    public Fraction plus(Fraction fraction) {
        long temp_num = numerator * fraction.denominator + fraction.numerator * denominator;
        long temp_denom = denominator * fraction.denominator;
        return new Fraction(temp_num, temp_denom);
    }

    public Fraction minus(Fraction fraction) {
        long temp_num = numerator * fraction.denominator - fraction.numerator * denominator;
        long temp_denom = denominator * fraction.denominator;;
        return new Fraction(temp_num, temp_denom);
    }

    public Fraction multiply(Fraction fraction) {
        return new Fraction(numerator * fraction.numerator, denominator * fraction.denominator);
    }

    public Fraction divide(Fraction fraction) {
        if(fraction.numerator == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return new Fraction(numerator * fraction.denominator, denominator * fraction.numerator);
    }

    private long gcd(long num, long denom) {
        return BigInteger.valueOf(num).gcd(BigInteger.valueOf(denom)).longValue();
    }

    @Override
    public String toString() {
        if(numerator == 0) {
            return "0";
        }
        return String.format("%d/%d", numerator, denominator);
    }
}
