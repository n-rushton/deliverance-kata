package codurance.kata;

import java.math.BigDecimal;

import static java.lang.Math.max;

public class PostageCalculator {
    public Money parcelPricing(int weight, int height, int width, int depth, Currency currency) {
        BigDecimal parcelCost = BigDecimal.valueOf(120);

        if (isLargeParcel(weight, height, width, depth)) {
            parcelCost = calculateTopTierPricing(weight, height, width, depth);
        }

        else if (isMediumParcel(weight, height, width, depth)) {
            parcelCost =  BigDecimal.valueOf(weight * 4);
        }

        return new Money(currency, parcelCost);

    }

    private boolean isMediumParcel(int weight, int height, int width, int depth) {
        return weight > 60 || height > 229 || width > 162 || depth > 25;
    }

    private boolean isLargeParcel(int weight, int height, int width, int depth) {
        return weight > 500 || height > 324 || width > 229 || depth > 100;
    }

    private BigDecimal calculateTopTierPricing(int weight, int height, int width, int depth) {
        BigDecimal weightPricingStrategy = BigDecimal.valueOf(weight * 6);
        BigDecimal dimensionPricingStrategy = BigDecimal.valueOf(height * width * depth * 6 * 0.001);
        return  weightPricingStrategy.max(dimensionPricingStrategy);
    }
}
