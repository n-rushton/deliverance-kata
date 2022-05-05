package codurance.kata;


import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CurrencyConverterTest {

    private final CurrencyConverter currencyConverter = new CurrencyConverter();
    private final Money moneyInGBP = new Money(Currency.GBP, BigDecimal.valueOf(100));

    @Test
    public void convert_from_GBP_to_EUR() {
        Money moneyInEUR = currencyConverter.convertFromGBP(moneyInGBP, Currency.EUR);
        Money expectedResult = new Money(Currency.EUR, BigDecimal.valueOf(142.8));

        assertEquals(expectedResult, moneyInEUR);
    }

    @Test
    public void convert_from_GBP_to_USD() {
        Money moneyInUSD = currencyConverter.convertFromGBP(moneyInGBP, Currency.USD);
        Money expectedResult = new Money(Currency.USD, BigDecimal.valueOf(150));

        assertEquals(expectedResult, moneyInUSD);
    }
}
