package price.formatter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import refactoring.DayOfYear;

/**
 * Write your tests for the PriceFormatter here. See the specification of the
 * PriceFormatter and formatPrice method in the PriceFormatter class and the
 * readme file.
 * 
 * // formatter = PriceFormatter
 * // Negative = negatiivinen luku
 * // Decimal Places To Two = desimaalit kahteen
 * 
 * // formatter = PriceFormatter
 * // Limits = rajoittaa
 * // Decimal Places = desimaalien määrä
 * // To Two = kahteen
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

    @Test
    void firstDayOfYearIsDayOne() {
        int paiva = DayOfYear.dayOfYear(1, 1, 2023);
        assertEquals(1, paiva);
    }

    @Test
    void firstDayOfNormalYear() {
        int paivanumero = DayOfYear.dayOfYear(12, 31, 2019);
        assertEquals(365, paivanumero);
    }

    @Test
    void firstDayOfLeapYear() {
        int paivanumero = DayOfYear.dayOfYear(12, 31, 2020);
        assertEquals(366, paivanumero);
    }

    @Test
    void dayOfYearFixed() {
        int paivanumero = DayOfYear.dayOfYear(12, 31, 2020);
        assertEquals(366, paivanumero);
    }

    @Test
    void leapYearFeb29IsDay60() {
        int paivanumero = DayOfYear.dayOfYear(2, 29, 2020);
        assertEquals(60, paivanumero);
    }

    @Test
    void feb29_2019() {
        assertThrows(IllegalArgumentException.class,
                () -> DayOfYear.dayOfYear(2, 29, 2019));
    }

    @Test
    void feb29OfNonLeapYearThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            DayOfYear.dayOfYear(2, 29, 2019);
        });
    }

    public static int dayOfYearFixed(int month, int dayOfMonth, int year) {

     return dayOfYearFixed(month, dayOfMonth, year);
    }

    // Uusi, korjattu ja refaktoroitu metodi vaaditulla allekirjoituksella
    public static int dayOfYearFixed(int month, int dayOfMonth, int year) {
        if (month < 1 || month > 12 || dayOfMonth < 1) {
            throw new IllegalArgumentException("Virheellinen kuukausi tai päivä.");
        }

        int[] kuukaudet = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        if (java.time.Year.isLeap(year)) {
            kuukaudet[2] = 29;
        }

        if (dayOfMonth > kuukaudet[month]) {
            throw new IllegalArgumentException("Virheellinen päivämäärä kyseiselle kuukaudelle.");
        }

        int paiviaYhteensa = 0;

        for (int i = 1; i < month; i++) {
            paiviaYhteensa += kuukaudet[i];
        }

        paiviaYhteensa += dayOfMonth;

        return paiviaYhteensa;
    }


    if (month < 1 || month > 12 || dayOfMonth < 1) {
        throw new IllegalArgumentException("Virheellinen kuukausi tai päivä.");
    }

    int[] kuukaudet = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    if (java.time.Year.isLeap(year)) {
        kuukaudet[2] = 29;
    }

    if (dayOfMonth > kuukaudet[month]) {
        throw new IllegalArgumentException("Virheellinen päivämäärä kyseiselle kuukaudelle.");
    }

    int paiviaYhteensa = 0;

    for (int i = 1; i < month; i++) {
        paiviaYhteensa += kuukaudet[i];
    }

    paiviaYhteensa += dayOfMonth;

    return paiviaYhteensa;