package codurance.kata;

import java.math.BigDecimal;

import static java.lang.Math.max;

public class PostageCalculator {
    public Money parcelPricing(int weight, int height, int width, int depth, Currency currency) {
        BigDecimal parcelCost = new SmallParcel(weight, height, width, depth).calculate();


        if (isLargeParcel(weight, height, width, depth)) {
            parcelCost = new LargeParcel(weight, height, width, depth).calculate();
        }

        else if (isMediumParcel(weight, height, width, depth)) {
            parcelCost =  new MediumParcel(weight, height, width, depth).calculate();
        }

        return new Money(currency, parcelCost);

    }

    private boolean isMediumParcel(int weight, int height, int width, int depth) {
        return weight > 60 || height > 229 || width > 162 || depth > 25;
    }

    private boolean isLargeParcel(int weight, int height, int width, int depth) {
        return weight > 500 || height > 324 || width > 229 || depth > 100;
    }

}
