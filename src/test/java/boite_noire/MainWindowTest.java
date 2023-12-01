package boite_noire;

import java.util.ArrayList;
import currencyConverter.Currency;
import currencyConverter.MainWindow;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainWindowTest {

    @Test
    public void testValeurs() {
        ArrayList<Currency> currencies = Currency.init();

        Double test1 = MainWindow.convert("USD", "USD", currencies, -100.0);
        Double test2 = MainWindow.convert("USD", "USD", currencies,-1.0);
        Double test3 = MainWindow.convert("USD", "USD", currencies,0.0);
        Double test4 = MainWindow.convert("USD", "USD", currencies,500000.0);
        Double test5 = MainWindow.convert("USD", "USD", currencies,1000000.0);
        Double test6 = MainWindow.convert("USD", "USD", currencies,1000001.0);
        Double test7 = MainWindow.convert("USD", "USD", currencies,1500000.0);

        // Valeurs acceptées
        Assertions.assertEquals(test3, 0.0);
        Assertions.assertEquals(test4, 500000.0);
        Assertions.assertEquals(test5, 1000000.0);

        // Valeurs non acceptées
        Assertions.assertNotEquals(test1, -100.0);
        Assertions.assertNotEquals(test2, -1.0);
        Assertions.assertNotEquals(test6, 1000001.0);
        Assertions.assertNotEquals(test7, 1500000.0);
    }

    @Test
    public void testChange() {
        // On passe dans toutes les combinaisons de devise et on fais la conversion de 1.0
        // Si la conversion fonctionne, on devrait avoir comme résultat le taux de conversion
        // 1 * taux = taux

        ArrayList<Currency> currencies = Currency.init();

        for (Currency currency1 : currencies) {
            for (Currency currency2 : currencies) {
                Double test = MainWindow.convert(currency1.getShortName(), currency2.getShortName(), currencies, 1.0);

                Assertions.assertEquals(test, currency1.getExchangeValues().get(currency2.getShortName()));
            }
        }
    }
}
