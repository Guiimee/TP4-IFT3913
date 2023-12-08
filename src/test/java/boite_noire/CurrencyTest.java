package boite_noire;

import currencyConverter.Currency;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CurrencyTest {

    @Test
    public void testValeurs() {
        // Pour tester la méthode convert de Currency, on prend le taux d'échange de 2
        // et les valeurs de [-100, -1, 0, 500 000, 1 000 000, 1 000 001, 1 500 000]

        Double test1 = Currency.convert(-100.0, 2.0);
        Double test2 = Currency.convert(-1.0, 2.0);
        Double test3 = Currency.convert(0.0, 2.0);
        Double test4 = Currency.convert(500000.0, 2.0);
        Double test5 = Currency.convert(1000000.0, 2.0);
        Double test6 = Currency.convert(1000001.0, 2.0);
        Double test7 = Currency.convert(1500000.0, 2.0);

        Assertions.assertAll(// Valeurs acceptées
                ()->    Assertions.assertEquals(test3, 0.0),
                ()->    Assertions.assertEquals(test4, 1000000.0),
                ()->    Assertions.assertEquals(test5, 2000000.0),

                            // Valeurs non acceptées
                ()->    Assertions.assertNotEquals(test1, -200.0),
                ()->    Assertions.assertNotEquals(test2, -2.0),
                ()->    Assertions.assertNotEquals(test6, 2000002.0),
                ()->    Assertions.assertNotEquals(test7, 3000000.0));
    }

    @Test
    public void testChange() {
        // On s'assure que plusieurs taux de change fonctionne
        Double test1 = Currency.convert(1.0, -1.0);
        Double test2 = Currency.convert(1.0, 0.0);
        Double test3 = Currency.convert(1.0, 0.5);
        Double test4 = Currency.convert(1.0, 1.0);
        Double test5 = Currency.convert(1.0, 2.0);
        Double test6 = Currency.convert(1.0, 5.0);

        Assertions.assertEquals(test1, -1.0);
        Assertions.assertEquals(test2, 0.0);
        Assertions.assertEquals(test3, 0.5);
        Assertions.assertEquals(test4, 1.0);
        Assertions.assertEquals(test5, 2.0);
        Assertions.assertEquals(test6, 5.0);
    }
}
