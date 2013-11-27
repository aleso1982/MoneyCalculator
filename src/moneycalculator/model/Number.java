package moneycalculator.model;

public class Number {
    
    private int numerator;
    private int denominator;

    public Number(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Number(Number number) {
        this(number.getNumerator(), number.getDenominator());
    }

    public Number(int number) {
        this(number, 1);
    }

    public Number(long number) {
        this((int)number, 1);
    }

    public Number(double number) {
        this(0, 1);
        toFraction(number);
    }
    
    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    private void toFraction(double number) {
        while ((long)number != number){
            number *= 10;
            denominator *= 10;
        }
        numerator = (int)number;
        reduce();
    }

    private void reduce() {
        PrimeNumbersCollection primes = new PrimeNumbersCollection();
        for (int prime : primes) {
            if (numerator < prime || denominator < prime)break;
            while (divisor(prime)) {
                numerator /= prime;
                denominator /= prime;
            }
        }
                
    }

    private boolean divisor(int number) {
        return (numerator % number == 0 && denominator % number == 0);        
    }

    @Override
    public String toString() {
        return denominator != 1 ? numerator + "/" + denominator:numerator +"";
    }
    
    
}
