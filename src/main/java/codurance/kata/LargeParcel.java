package codurance.kata;

import java.math.BigDecimal;

public class LargeParcel extends Parcel{
    public LargeParcel(int weight, int height, int width, int depth) {
        super(weight, height, width, depth);
    }

    @Override
    public BigDecimal calculate() {
        BigDecimal weightPricingStrategy = BigDecimal.valueOf(weight * 6);
        BigDecimal dimensionPricingStrategy = BigDecimal.valueOf(height * width * depth * 6 * 0.001);
        return  weightPricingStrategy.max(dimensionPricingStrategy);
    }
}
