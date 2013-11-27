package moneycalculator.persistance;

import java.util.Date;
import moneycalculator.model.Currency;
import moneycalculator.model.ExchangeRate;

public interface ExchangeRateLoader {
    
    public ExchangeRate load(Currency from, Currency to, Date date);
    public ExchangeRate load(Currency from, Currency to);
}
