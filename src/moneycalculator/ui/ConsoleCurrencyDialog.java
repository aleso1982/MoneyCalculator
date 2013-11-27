package moneycalculator.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import moneycalculator.model.Currency;
import moneycalculator.model.CurrencySet;

public class ConsoleCurrencyDialog implements CurrencyDialog {

    private Currency currency;

    @Override
    public void execute() {
        while (true) {
            System.out.println("Introduzca una divisa: ");
            String line = readLine();
            Currency[] currencies = CurrencySet.getInstance().search(line);
            if (check(currencies)) {
                break;
            }
        }
    }

    @Override
    public Currency getCurrency() {
        return currency;
    }

    private String readLine() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        try {
            line = reader.readLine();
        } catch (IOException ex) {
        }
        return line;
    }

    private boolean check(Currency[] currencies) {
        if (currencies.length == 0) {
            System.out.println("Moneda no encontrada");
            return false;
        }

        if (currencies.length == 1) {
            currency = currencies[0];
            return true;
        }

        if (currencies.length > 1) {
            System.out.println("Hay múltiples coincidencias para esa divisa: ");
            for (Currency currency1 : currencies) {
                System.out.println(currency1);
            }
            return false;
        }
        return false;
    }

}
