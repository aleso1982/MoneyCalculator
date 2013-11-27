package moneycalculator.ui;

import moneycalculator.model.Currency;
import moneycalculator.model.Money;

public interface MoneyViewer {
    
    public void show(Money money, Currency currency);

}
