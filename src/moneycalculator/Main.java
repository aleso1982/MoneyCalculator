package moneycalculator;

import moneycalculator.persistance.CurrencySetLoader;
import moneycalculator.persistance.ExchangeRateLoader;
import moneycalculator.persistance.MockExchangeRateLoader;
import moneycalculator.ui.ConsoleCurrencyDialog;
import moneycalculator.ui.ConsoleMoneyDialog;
import moneycalculator.ui.ConsoleMoneyViewer;
import moneycalculator.ui.CurrencyDialog;
import moneycalculator.ui.MoneyDialog;
import moneycalculator.ui.MoneyViewer;

public class Main {

    public static void main(String[] args) {

        System.out.println("*****   MONEY CALCULATOR  *****");
        System.out.println("Como prueba solo está disponible el cambio entre euros y dollar americano");
        CurrencySetLoader.getInstance().load();
        ExchangeMoneyControl control = new ExchangeMoneyControl(
                createExchangeRateLoader(),
                createCurrencyDialog(),
                createMoneyDialog(),
                createMoneyViewer());
        control.execute();

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
