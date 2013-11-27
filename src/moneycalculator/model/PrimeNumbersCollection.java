package moneycalculator.model;

import java.util.Iterator;

public class PrimeNumbersCollection implements Iterable<Integer>{
    
    private int number;

    public PrimeNumbersCollection() {
        number = 1;
    }
    
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {

            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public Integer next() {
                while(true)
                    if (isPrime(++number)) return number;
            }

            @Override
            public void remove() {
            }

            private boolean isPrime(int number) {
                for (int i = 2; i < number; i++)
                    if (number%i==0) return false;
                return true;
            }
        };
    }
}
