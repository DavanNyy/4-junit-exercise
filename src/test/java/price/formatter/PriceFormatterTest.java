package price.formatter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

/**
 * Write your tests for the PriceFormatter here. See the specification of the
 * PriceFormatter and formatPrice method in the PriceFormatter class and the
 * readme file.
 * 
 *  // formatter = PriceFormatter
    // Negative = negatiivinen luku
    // Decimal Places To Two = desimaalit kahteen

    // formatter = PriceFormatter
    // Limits = rajoittaa
    // Decimal Places = desimaalien määrä
    // To Two = kahteen
 */
public class PriceFormatterTest {
    private final PriceFormatter formatter = new PriceFormatter();

    // 3.14159
    // 123456.78 
    // 123
    // 6.7
    // 4.567

    @Test
    void formatterLimitsDecimalPlacesToTwo() {
        String formatted = formatter.formatPrice(3.14159);
        assertEquals("3,14 €", formatted);
    }
    @Test
    void formatterNegativeDecimalPlacesToTwo() {
        String formatted = formatter.formatPrice(-3.14159);
        assertEquals("-3,14 €", formatted);
    }
    @Test
    void formatterUsesSpaceAsThousandSeparator() {
        String formatted = formatter.formatPrice(123456.78);
        assertEquals("123 456,78 €", formatted);
    }
    @Test
    void formatterPrintsDigitsAndEuro() {
        String formatted = formatter.formatPrice(123);
        assertEquals("123 €", formatted);
    }
    @Test
    void formatterListsTwoDecimals() {
        String formatted = formatter.formatPrice(6.7);
        assertEquals("6,70 €", formatted);
    }
    @Test
    void formatterRoundsToTwoDecimalPlaces() {
        String formatted = formatter.formatPrice(4.567);
        assertEquals("4,57 €", formatted);
    }
}
