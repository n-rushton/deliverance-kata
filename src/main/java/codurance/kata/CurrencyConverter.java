package codurance.kata;

import java.math.BigDecimal;

public class CurrencyConverter {
    final BigDecimal CONVERSION_CHARGE = BigDecimal.valueOf(20);
    final BigDecimal EUR_EXCHANGE_RATE = BigDecimal.valueOf(1.19);
    final BigDecimal USD_EXCHANGE_RATE = BigDecimal.valueOf(1.25);

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
            return EUR_EXCHANGE_RATE;
        }
        return USD_EXCHANGE_RATE;
    }
}