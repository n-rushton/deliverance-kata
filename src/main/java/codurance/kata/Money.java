package codurance.kata;
import java.math.BigDecimal;

public record Money(Currency currency, BigDecimal amount) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Money money = (Money) o;

        if (currency != money.currency) return false;
        return (amount.compareTo(money.amount)) == 0;
    }

    @Override
    public int hashCode() {
        int result = currency != null ? currency.hashCode() : 0;
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        return result;
    }
}
