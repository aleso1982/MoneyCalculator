package moneycalculator.model;

import java.util.Date;

public class ExchangeRate {
    
   private final Currency fromCurrency;
   private final Currency toCurrency;
   private final Number rate;
   private final Date date;

    public ExchangeRate(Currency fromCurrency, Currency toCurrency, Number rate, Date date) {
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.rate = rate;
        this.date = date;
    }

    public Currency getFromCurrency() {
        return fromCurrency;
    }

    public Currency getToCurrency() {
        return toCurrency;
    }

    public Number getRate() {
        return rate;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Moneda origen: " + getFromCurrency().getName() +
               "\nMoneda destino:" + getToCurrency().getName() + 
                "\nRate: " + rate;
    }
    
    
    
}
