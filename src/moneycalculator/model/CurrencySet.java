package moneycalculator.model;

import java.util.ArrayList;
import java.util.HashSet;

public class CurrencySet extends HashSet<Currency>{
    
    private static CurrencySet instance;

    private CurrencySet() {
        super();
    }
    
    public static CurrencySet getInstance(){
        if (instance == null) 
            instance = new CurrencySet();
        return instance;
    }
    
    public Currency[] search(String token){
        ArrayList<Currency> list = new ArrayList<Currency>();
        
        for (Currency currency : this) {
            if (currency.getCode().equalsIgnoreCase(token))
                list.add(currency);
            else if (currency.getSymbol().equalsIgnoreCase(token))
                list.add(currency);
            else if (currency.getName().equalsIgnoreCase(token))
                list.add(currency);
        }
        
        return list.toArray(new Currency[0]);
    }
    
    public void showCurrencies(){
        for (Currency currency : this) {
            System.out.println(currency);
        }
    }

}
