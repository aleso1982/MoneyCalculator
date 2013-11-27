package moneycalculator;

import java.util.Date;
import moneycalculator.model.Currency;
import moneycalculator.model.CurrencySet;
import moneycalculator.model.ExchangeRate;
import moneycalculator.persistance.CurrencySetLoader;
import moneycalculator.persistance.ExchangeRateLoader;
import moneycalculator.persistance.MockExchangeRateLoader;
import moneycalculator.ui.ConsoleCurrencyDialog;
import moneycalculator.ui.ConsoleMoneyDialog;
import moneycalculator.ui.ConsoleMoneyViewer;
import moneycalculator.ui.CurrencyDialog;
import moneycalculator.ui.MoneyDialog;
import moneycalculator.ui.MoneyViewer;
import moneycalculator.model.Number;

public class Main {

    public static void main(String[] args) {
        /*System.out.println("*****   PRUEBA INICIAL *****");
        CurrencySetLoader.getInstance().load();
        CurrencySet.getInstance().showCurrencies();
        Currency a = new Currency("USD", "Dollar Americano", "$");
        Currency b = new Currency("EUR", "Euro", "€");
        ExchangeRate exchangeRate = new ExchangeRate(a, b, new Number(2.3), new Date());
        System.out.println(exchangeRate);
        System.out.println("*****   FIN PRUEBA INICIAL  *****\n");*/

        System.out.println("*****   SEGUNDA PRUEBA  *****");
        CurrencySetLoader.getInstance().load();
        ExchangeMoneyControl control = new ExchangeMoneyControl(
                createExchangeRateLoader(),
                createCurrencyDialog(),
                createMoneyDialog(),
                createMoneyViewer());
        control.execute();
        System.out.println("*****   FIN SEGUNDA PRUEBA  *****");

    }

    private static ExchangeRateLoader createExchangeRateLoader() {
        return new MockExchangeRateLoader();
    }

    private static CurrencyDialog createCurrencyDialog() {
        return new ConsoleCurrencyDialog();
    }

    private static MoneyDialog createMoneyDialog() {
        return new ConsoleMoneyDialog();
    }

    private static MoneyViewer createMoneyViewer() {
        return new ConsoleMoneyViewer();
    }
}
