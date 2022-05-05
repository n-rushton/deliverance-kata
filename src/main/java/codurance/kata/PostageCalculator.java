package codurance.kata;

import java.math.BigDecimal;

import static java.lang.Math.max;

public class PostageCalculator {
    public Money parcelPricing(int weight, int height, int width, int depth, Currency currency) {
        BigDecimal parcelCost = BigDecimal.valueOf(120);

        if (weight > 500) {
            parcelCost = calculateTopTierPricing(weight, height, width, depth);
        }

        else if (weight > 60) {
            parcelCost =  BigDecimal.valueOf(weight * 4);
        }

        return new Money(currency, parcelCost);

    }

    private BigDecimal calculateTopTierPricing(int weight, int height, int width, int depth) {
        BigDecimal weightPricingStrategy = BigDecimal.valueOf(weight * 6);
        BigDecimal dimensionPricingStrategy = BigDecimal.valueOf(height * width * depth * 6 * 0.001);
        return  weightPricingStrategy.max(dimensionPricingStrategy);
    }
}
