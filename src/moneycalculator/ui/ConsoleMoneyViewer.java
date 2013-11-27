package moneycalculator.ui;

import moneycalculator.model.Currency;
import moneycalculator.model.Money;

public class ConsoleMoneyViewer implements MoneyViewer{

    @Override
    public void show(Money money, Currency currency) {
        System.out.println(money);
    }
}
