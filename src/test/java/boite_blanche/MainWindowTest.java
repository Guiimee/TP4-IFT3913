package boite_blanche;

import currencyConverter.Currency;
import currencyConverter.MainWindow;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class MainWindowTest {

    @Test
    public void testControleGraph() {
        ArrayList<Currency> currencies = Currency.init();

        Double test1 = MainWindow.convert("US Dollar", "Euro", currencies,1.0);
        Double test2 = MainWindow.convert("US Dollar", "CA Dollar", currencies,1.0);
        Double test3 = MainWindow.convert("CA Dollar", "US Dollar", currencies,1.0);


        Assertions.assertAll(
                ()->    Assertions.assertEquals(test1, 0.93),
                ()->    Assertions.assertEquals(test2, 0.0),
                ()->    Assertions.assertEquals(test3, 0.0));
    }
}
