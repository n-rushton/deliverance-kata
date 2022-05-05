package codurance.kata;
import java.math.BigDecimal;

public class Money {

    private final Currency currency;
    private final BigDecimal amount;
    private final BigDecimal CONVERSION_CHARGE = BigDecimal.valueOf(20);
    private final double EUR_EXCHANGE_RATE = 1.19;
    private final double USD_EXCHANGE_RATE = 1.25;

    public Money(Currency currency, BigDecimal amount) {
        this.currency = currency;
        this.amount = amount;
    }

    public Money convertFromGBP(Currency currencyToConvertTo) {

        if (currencyToConvertTo == Currency.GBP) {
            return this;
        }

        BigDecimal conversionRate = getConversionRate(currencyToConvertTo);
        BigDecimal convertedAmount = (amount.add(CONVERSION_CHARGE)).multiply(conversionRate);

        return new Money(currencyToConvertTo, convertedAmount);
    }

    private BigDecimal getConversionRate(Currency currencyToConvertTo) {
        if (currencyToConvertTo == Currency.EUR) {
            return BigDecimal.valueOf(EUR_EXCHANGE_RATE);
        }
        return BigDecimal.valueOf(USD_EXCHANGE_RATE);
    }

    @Override
    public String toString() {
        return "Money{" +
                "currency=" + currency +
                ", amount=" + amount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Money money = (Money) o;

        if (currency != money.currency)
            return false;

        return amount.compareTo(money.amount) == 0;
    }

    @Override
    public int hashCode() {
        int result = currency != null ? currency.hashCode() : 0;
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        return result;
    }
}
