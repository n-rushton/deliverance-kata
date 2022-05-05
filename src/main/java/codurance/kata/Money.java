package codurance.kata;
import java.math.BigDecimal;

public class Money {

    private final Currency currency;
    private final BigDecimal amount;

    public Money(Currency currency, BigDecimal amount) {
        this.currency = currency;
        this.amount = amount;
    }

    public Money convertFromGBP(Currency currencyToConvertTo) {

        if (currencyToConvertTo == Currency.GBP) {
            return this;
        }


        BigDecimal conversionAmount = BigDecimal.valueOf(1.19);

        if (currencyToConvertTo == Currency.USD) {
            conversionAmount = BigDecimal.valueOf(1.25);
        }

        BigDecimal newAmount = (amount.add(BigDecimal.valueOf(20))).multiply(conversionAmount);

        return new Money(currencyToConvertTo, newAmount);
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
