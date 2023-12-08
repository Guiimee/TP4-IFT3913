package boite_blanche;

import currencyConverter.Currency;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CurrencyTest {

    @Test
    public void testInstructions() {
        Double test1 = Currency.convert(500000.0, 2.0);
        Assertions.assertEquals(test1, 1000000.0);
    }
}
