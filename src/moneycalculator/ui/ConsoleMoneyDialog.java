package moneycalculator.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import moneycalculator.model.Money;

public class ConsoleMoneyDialog implements MoneyDialog {
    
    private Money money;

    @Override
    public void execute() {
        try {
            BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
            moneycalculator.model.Number number = new moneycalculator.model.Number(Double.valueOf(readAmount(read)));
            ConsoleCurrencyDialog currency = new ConsoleCurrencyDialog();
            currency.execute();
            money = new Money(number, currency.getCurrency());
        } catch (IOException ex) {
            Logger.getLogger(ConsoleMoneyDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Money getMoney() {
        return money;
    }

    private String readAmount(BufferedReader read) throws IOException {
        System.out.println("Introduzca una cantidad: ");
        return read.readLine();
    }

}
