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

        Double test1 = MainWindow.convert("US Dollar", "US Dollar", currencies, -100.0);
        Double test2 = MainWindow.convert("US Dollar", "US Dollar", currencies,-1.0);
        Double test3 = MainWindow.convert("US Dollar", "US Dollar", currencies,0.0);
        Double test4 = MainWindow.convert("US Dollar", "US Dollar", currencies,500000.0);
        Double test5 = MainWindow.convert("US Dollar", "US Dollar", currencies,1000000.0);
        Double test6 = MainWindow.convert("US Dollar", "US Dollar", currencies,1000001.0);
        Double test7 = MainWindow.convert("US Dollar", "US Dollar", currencies,1500000.0);

        Assertions.assertAll(// Valeurs acceptées
                ()->    Assertions.assertEquals(test3, 0.0),
                ()->    Assertions.assertEquals(test4, 500000.0),
                ()->    Assertions.assertEquals(test5, 1000000.0),

                            // Valeurs non acceptées
                ()->    Assertions.assertNotEquals(test1, -100.0),
                ()->    Assertions.assertNotEquals(test2, -1.0),
                ()->    Assertions.assertNotEquals(test6, 1000001.0),
                ()->    Assertions.assertNotEquals(test7, 1500000.0));
    }

    @Test
    public void testChange() {
        // On passe dans toutes les combinaisons de devise et on fais la conversion de 1.0
        // Si la conversion fonctionne, on devrait avoir comme résultat le taux de conversion
        // 1 * taux = taux
        ArrayList<Currency> currencies = Currency.init();

        Double test1 = MainWindow.convert("US Dollar", "US Dollar", currencies, 1.0);
        Double test2 = MainWindow.convert("US Dollar", "CA Dollar", currencies, 1.0);
        Double test3 = MainWindow.convert("US Dollar", "British Pound", currencies, 1.0);
        Double test4 = MainWindow.convert("US Dollar", "Euro", currencies, 1.0);
        Double test5 = MainWindow.convert("US Dollar", "Swiss Franc", currencies, 1.0);
        Double test6 = MainWindow.convert("US Dollar", "AU Dollar", currencies, 1.0);

        Double test7 = MainWindow.convert("CA Dollar", "US Dollar", currencies, 1.0);
        Double test8 = MainWindow.convert("CA Dollar", "CA Dollar", currencies, 1.0);
        Double test9 = MainWindow.convert("CA Dollar", "British Pound", currencies, 1.0);
        Double test10 = MainWindow.convert("CA Dollar", "Euro", currencies, 1.0);
        Double test11 = MainWindow.convert("CA Dollar", "Swiss Franc", currencies, 1.0);
        Double test12 = MainWindow.convert("CA Dollar", "AU Dollar", currencies, 1.0);

        Double test13 = MainWindow.convert("British Pound", "US Dollar", currencies, 1.0);
        Double test14 = MainWindow.convert("British Pound", "CA Dollar", currencies, 1.0);
        Double test15 = MainWindow.convert("British Pound", "British Pound", currencies, 1.0);
        Double test16 = MainWindow.convert("British Pound", "Euro", currencies, 1.0);
        Double test17 = MainWindow.convert("British Pound", "Swiss Franc", currencies, 1.0);
        Double test18 = MainWindow.convert("British Pound", "AU Dollar", currencies, 1.0);

        Double test19 = MainWindow.convert("Euro", "US Dollar", currencies, 1.0);
        Double test20 = MainWindow.convert("Euro", "CA Dollar", currencies, 1.0);
        Double test21 = MainWindow.convert("Euro", "British Pound", currencies, 1.0);
        Double test22 = MainWindow.convert("Euro", "Euro", currencies, 1.0);
        Double test23 = MainWindow.convert("Euro", "Swiss Franc", currencies, 1.0);
        Double test24 = MainWindow.convert("Euro", "AU Dollar", currencies, 1.0);

        Double test25 = MainWindow.convert("Swiss Franc", "US Dollar", currencies, 1.0);
        Double test26 = MainWindow.convert("Swiss Franc", "CA Dollar", currencies, 1.0);
        Double test27 = MainWindow.convert("Swiss Franc", "British Pound", currencies, 1.0);
        Double test28 = MainWindow.convert("Swiss Franc", "Euro", currencies, 1.0);
        Double test29 = MainWindow.convert("Swiss Franc", "Swiss Franc", currencies, 1.0);
        Double test30 = MainWindow.convert("Swiss Franc", "AU Dollar", currencies, 1.0);

        Double test31 = MainWindow.convert("AU Dollar", "US Dollar", currencies, 1.0);
        Double test32 = MainWindow.convert("AU Dollar", "CA Dollar", currencies, 1.0);
        Double test33 = MainWindow.convert("AU Dollar", "British Pound", currencies, 1.0);
        Double test34 = MainWindow.convert("AU Dollar", "Euro", currencies, 1.0);
        Double test35 = MainWindow.convert("AU Dollar", "Swiss Franc", currencies, 1.0);
        Double test36 = MainWindow.convert("AU Dollar", "AU Dollar", currencies, 1.0);


        Assertions.assertAll(
                // USD
                ()->    Assertions.assertEquals(test1, 1.0),//USD
                ()->    Assertions.assertEquals(test2, 1.36),//CAD
                ()->    Assertions.assertEquals(test3, 0.66),//GBP
                ()->    Assertions.assertEquals(test4, 0.93),//EUR
                ()->    Assertions.assertEquals(test5, 1.01),//CHF
                ()->    Assertions.assertEquals(test6, 1.52),//AUD

                // CAD
                ()->    Assertions.assertEquals(test7, 0.74),//USD
                ()->    Assertions.assertEquals(test8, 1.0),//CAD
                ()->    Assertions.assertEquals(test9, 0.59),//GBP
                ()->    Assertions.assertEquals(test10, 0.68),//EUR
                ()->    Assertions.assertEquals(test11, 0.65),//CHF
                ()->    Assertions.assertEquals(test12, 1.12),//AUD

                // GBP
                ()->    Assertions.assertEquals(test13, 1.51),//USD
                ()->    Assertions.assertEquals(test14, 1.70),//CAD
                ()->    Assertions.assertEquals(test15, 1.0),//GBP
                ()->    Assertions.assertEquals(test16, 1.41),//EUR
                ()->    Assertions.assertEquals(test17, 1.52),//CHF
                ()->    Assertions.assertEquals(test18, 1.91),//AUD

                // EUR
                ()->    Assertions.assertEquals(test19, 1.073),//USD
                ()->    Assertions.assertEquals(test20, 1.46),//CAD
                ()->    Assertions.assertEquals(test21, 0.71),//GBP
                ()->    Assertions.assertEquals(test22, 1.0),//EUR
                ()->    Assertions.assertEquals(test23, 1.08),//CHF
                ()->    Assertions.assertEquals(test24, 1.64),//AUD

                // CHF
                ()->    Assertions.assertEquals(test25, 0.99),//USD
                ()->    Assertions.assertEquals(test26, 1.54),//CAD
                ()->    Assertions.assertEquals(test27, 0.66),//GBP
                ()->    Assertions.assertEquals(test28, 0.93),//EUR
                ()->    Assertions.assertEquals(test29, 1.0),//CHF
                ()->    Assertions.assertEquals(test30, 1.73),//AUD

                //AUD
                ()->    Assertions.assertEquals(test31, 0.66),//USD
                ()->    Assertions.assertEquals(test32, 0.89),//CAD
                ()->    Assertions.assertEquals(test33, 0.52),//GBP
                ()->    Assertions.assertEquals(test34, 0.61),//EUR
                ()->    Assertions.assertEquals(test35, 0.58),//CHF
                ()->    Assertions.assertEquals(test36, 1.0));//AUD
    }
}
