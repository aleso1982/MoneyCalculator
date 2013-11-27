package moneycalculator.persistance;

import moneycalculator.model.Currency;
import moneycalculator.model.CurrencySet;

public class CurrencySetLoader {
    
    private static CurrencySetLoader instance;

    private CurrencySetLoader() {
    }
    
    public static CurrencySetLoader getInstance(){
        if (instance == null) {
            instance = new CurrencySetLoader();
        }
        return instance;
    }
    
    public void load(){
        CurrencySet currencySet = CurrencySet.getInstance();
        currencySet.add(new Currency("EUR", "Euro", "€"));
        currencySet.add(new Currency("USD", "dolar Americano", "$"));
    }

}
