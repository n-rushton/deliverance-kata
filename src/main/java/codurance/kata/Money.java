package codurance.kata;
import java.math.BigDecimal;
import java.util.Objects;

public class Money {
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

    private final Currency currency;
    private final BigDecimal amount;

    public Money(Currency currency, BigDecimal amount) {
        this.currency = currency;
        this.amount = amount;
    }

    public Money convert(Currency currencyToConvertTo) {

        BigDecimal newAmount = (amount.add(BigDecimal.valueOf(20))).multiply(BigDecimal.valueOf(1.19));

        return new Money(currencyToConvertTo, newAmount);
    }
}
