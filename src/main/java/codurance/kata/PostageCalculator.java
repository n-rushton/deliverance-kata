package codurance.kata;

import java.math.BigDecimal;

public class PostageCalculator {
    public Money parcelPricing(int weight, int height, int width, int depth, Currency currency) {
        if (weight > 500) {
            return new Money(currency, BigDecimal.valueOf(height * width * depth * 6 * 0.001));
        }

        if (weight > 60) {
            return new Money(currency, BigDecimal.valueOf(weight * 4));
        }
        return new Money(currency, BigDecimal.valueOf(120));

    }
}
