package boite_blanche;

import currencyConverter.Currency;
import currencyConverter.MainWindow;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class MainWindowTest {

    @Test
    public void testIChemin() {
        ArrayList<Currency> currencies = Currency.init();

        Double test1 = MainWindow.convert("USD", "USD", currencies, 1.0);
        Double test2 = MainWindow.convert("USD", "EUR", currencies,1.0);
        Double test3 = MainWindow.convert("USD", "GBP", currencies,1.0);
        Double test4 = MainWindow.convert("USD", "CHF", currencies,1.0);
        Double test5 = MainWindow.convert("USD", "CNY", currencies,1.0);
        Double test6 = MainWindow.convert("USD", "JPY", currencies,1.0);
        Double test7 = MainWindow.convert("USD", "CAD", currencies,1.0);

        Double test8 = MainWindow.convert("EUR", "USD", currencies,1.0);
        Double test9 = MainWindow.convert("GBP", "USD", currencies,1.0);
        Double test10 = MainWindow.convert("CHF", "USD", currencies,1.0);
        Double test11 = MainWindow.convert("CNY", "USD", currencies,1.0);
        Double test12 = MainWindow.convert("JPY", "USD", currencies,1.0);
        Double test13 = MainWindow.convert("CAD", "USD", currencies,1.0);



        Assertions.assertEquals(test1, 1.0);
        Assertions.assertEquals(test2, 0.93);
        Assertions.assertEquals(test3, 0.66);
        Assertions.assertEquals(test4, 1.01);
        Assertions.assertEquals(test5, 6.36);
        Assertions.assertEquals(test6, 123.54);
        Assertions.assertEquals(test7, 0.0);

        Assertions.assertEquals(test8, 1.073);
        Assertions.assertEquals(test9, 1.51);
        Assertions.assertEquals(test10, 0.99);
        Assertions.assertEquals(test11, 0.16);
        Assertions.assertEquals(test12, 0.008);
        Assertions.assertEquals(test13, 0.0);
    }
}
