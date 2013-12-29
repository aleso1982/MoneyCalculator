package moneycalculator.ui;

import java.util.Date;
import moneycalculator.model.Currency;
import moneycalculator.model.ExchangeRate;
import moneycalculator.model.Money;
import moneycalculator.model.Number;
import moneycalculator.persistance.MockExchangeRateLoader;

public class ConsoleMoneyViewer implements MoneyViewer{

    @Override
    public void show(Money money, Currency currency) {
        ExchangeRate exchangeRate = new MockExchangeRateLoader().load(money.getCurrency(), currency, new Date());
        String sourceCode = money.getCurrency().getCode();
        String destinationCode = currency.getCode();
        int numerator = exchangeRate.getRate().getNumerator() * money.getAmount().getNumerator();
        int denominator = exchangeRate.getRate().getDenominator() * money.getAmount().getDenominator();
        Number destinationAmount = new Number(numerator, denominator);
        System.out.println("Los " + money.getAmount() + " " + sourceCode + " equivalen a " + destinationAmount  + " " + destinationCode);
        System.out.println("rate: " + exchangeRate.getRate());
    }
}
