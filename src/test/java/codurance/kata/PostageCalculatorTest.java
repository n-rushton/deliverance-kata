package codurance.kata;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PostageCalculatorTest {

    private final int LOWER_TIER_HEIGHT = 229;
    private final int LOWER_TIER_WIDTH = 162;
    private final int LOWER_TIER_DEPTH = 25;


    private final int LOWER_TIER_WEIGHT = 60;
    private final int MID_TIER_WEIGHT = 500;
    private final int TOP_TIER_WEIGHT = 501;

    @Test
    public void apply_small_parcel_pricing_to_a_package_with_lower_tier_dimensions_and_weight() {

        Money expectedCost = new Money(Currency.GBP, BigDecimal.valueOf(120));

        PostageCalculator postageCalculator = new PostageCalculator();
        Money postageCost = postageCalculator.parcelPricing(LOWER_TIER_WEIGHT, LOWER_TIER_HEIGHT, LOWER_TIER_WIDTH, LOWER_TIER_DEPTH, Currency.GBP);

        assertEquals(expectedCost, postageCost);
    }

    @Test
    public void apply_mid_parcel_pricing_to_a_package_with_lower_tier_dimensions_but_mid_tier_weight() {

        BigDecimal expectedPriceInPence = BigDecimal.valueOf(MID_TIER_WEIGHT * 4);
        Money expectedCost = new Money(Currency.GBP, expectedPriceInPence);

        PostageCalculator postageCalculator = new PostageCalculator();
        Money postageCost = postageCalculator.parcelPricing(MID_TIER_WEIGHT, LOWER_TIER_HEIGHT, LOWER_TIER_WIDTH, LOWER_TIER_DEPTH, Currency.GBP);

        assertEquals(expectedCost, postageCost);
    }

    @Test
    public void apply_large_parcel_pricing_to_a_package_with_lower_tier_dimensions_but_large_tier_weight_pricing_strategy_1() {

        BigDecimal expectedPriceInPence = BigDecimal.valueOf(LOWER_TIER_HEIGHT * LOWER_TIER_WIDTH * LOWER_TIER_DEPTH * 6 * 0.001);
        Money expectedCost = new Money(Currency.GBP, expectedPriceInPence);

        PostageCalculator postageCalculator = new PostageCalculator();
        Money postageCost = postageCalculator.parcelPricing(TOP_TIER_WEIGHT, LOWER_TIER_HEIGHT, LOWER_TIER_WIDTH, LOWER_TIER_DEPTH, Currency.GBP);

        assertEquals(expectedCost, postageCost);
    }

    @Test
    public void apply_large_parcel_pricing_to_a_package_with_lower_tier_dimensions_but_large_tier_weight_pricing_strategy_2() {

        BigDecimal expectedPriceInPence = BigDecimal.valueOf(TOP_TIER_WEIGHT * 6);
        Money expectedCost = new Money(Currency.GBP, expectedPriceInPence);

        PostageCalculator postageCalculator = new PostageCalculator();
        Money postageCost = postageCalculator.parcelPricing(TOP_TIER_WEIGHT, 10, 20, 10, Currency.GBP);

        assertEquals(expectedCost, postageCost);
    }



}
