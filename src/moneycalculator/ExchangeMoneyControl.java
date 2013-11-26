package moneycalculator;

import moneycalculator.model.Currency;
import moneycalculator.model.Money;
import moneycalculator.persistance.ExchangeRateLoader;
import moneycalculator.ui.CurrencyDialog;
import moneycalculator.ui.MoneyDialog;
import moneycalculator.ui.MoneyViewer;

public class ExchangeMoneyControl {
    
    private ExchangeRateLoader exchangeRateLouder;
    private CurrencyDialog currencyDialog;
    private MoneyDialog moneyDialog;
    private MoneyViewer moneyViewer;

    public ExchangeMoneyControl(
            ExchangeRateLoader exchangeRateLouder, 
            CurrencyDialog currencyDialog, 
            MoneyDialog moneyDialog, 
            MoneyViewer moneyViewer) {
        this.exchangeRateLouder = exchangeRateLouder;
        this.currencyDialog = currencyDialog;
        this.moneyDialog = moneyDialog;
        this.moneyViewer = moneyViewer;
    }
    
    public void execute() {
        Money money = readMoney();
        Currency currency = readCurrency();
        exchangeRateLouder.load(money.getCurrency(), currency);
        moneyViewer.show(money, currency);
        
    }

    private Money readMoney() {
        moneyDialog.execute();
        return moneyDialog.getMoney();
    }

    private Currency readCurrency() {
        currencyDialog.execute();
        return currencyDialog.getCurrency();
    }
    
}
