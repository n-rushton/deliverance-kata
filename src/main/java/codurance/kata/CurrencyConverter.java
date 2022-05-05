package codurance.kata;

import java.math.BigDecimal;

public class CurrencyConverter {
    final BigDecimal CONVERSION_CHARGE = BigDecimal.valueOf(20);
    final double EUR_EXCHANGE_RATE = 1.19;
    final double USD_EXCHANGE_RATE = 1.25;

    public CurrencyConverter() {
    }

    public Money convertFromGBP(Money money, Currency currencyToConvertTo) {

        if (currencyToConvertTo == Currency.GBP) {
            return money;
        }
        BigDecimal conversionRate = getConversionRate(currencyToConvertTo);
        BigDecimal convertedAmount = (money.amount().add(CONVERSION_CHARGE)).multiply(conversionRate);

        return new Money(currencyToConvertTo, convertedAmount);
    }

    public BigDecimal getConversionRate(Currency currencyToConvertTo) {
        if (currencyToConvertTo == Currency.EUR) {
            return BigDecimal.valueOf(EUR_EXCHANGE_RATE);
        }
        return BigDecimal.valueOf(USD_EXCHANGE_RATE);
    }
}