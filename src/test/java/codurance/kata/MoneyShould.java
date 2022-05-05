package codurance.kata;


import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoneyShould {

    @Test
    public void convert_from_GBP_to_EUR() {
        Money moneyInGBP = new Money(Currency.GBP, BigDecimal.valueOf(100));
        Money moneyInEUR = moneyInGBP.convert(Currency.EUR);
        Money expectedResult = new Money(Currency.EUR, BigDecimal.valueOf(142.8));

        assertEquals(expectedResult, moneyInEUR);
    }


}
