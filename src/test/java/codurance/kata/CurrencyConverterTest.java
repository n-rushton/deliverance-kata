package codurance.kata;


import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CurrencyConverterTest {

    @Test
    public void convert_from_GBP_to_EUR() {
        CurrencyConverter currencyConverter = new CurrencyConverter();

        Money moneyInGBP = new Money(Currency.GBP, BigDecimal.valueOf(100));
        Money moneyInEUR = currencyConverter.convertFromGBP(moneyInGBP, Currency.EUR);
        Money expectedResult = new Money(Currency.EUR, BigDecimal.valueOf(142.8));

        assertEquals(expectedResult, moneyInEUR);
    }

    @Test
    public void convert_from_GBP_to_USD() {
        CurrencyConverter currencyConverter = new CurrencyConverter();

        Money moneyInGBP = new Money(Currency.GBP, BigDecimal.valueOf(100));
        Money moneyInEUR = currencyConverter.convertFromGBP(moneyInGBP, Currency.USD);
        Money expectedResult = new Money(Currency.USD, BigDecimal.valueOf(150));

        assertEquals(expectedResult, moneyInEUR);
    }
}
