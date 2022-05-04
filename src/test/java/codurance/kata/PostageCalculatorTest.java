package codurance.kata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PostageCalculatorTest {

    @Test
    public void apply_small_parcel_pricing_to_a_package_with_lower_tier_dimensions_and_weight() {

        Money expectedCost = new Money(Currency.GBP, 120);
        PostageCalculator postageCalculator = new PostageCalculator();
        int weight = 60;
        int height = 229;
        int width = 162;
        int depth = 25;
        Money postageCost = postageCalculator.parcelPricing(weight, height, width, depth, Currency.GBP);
        assertEquals(expectedCost, postageCost);

    }
}
