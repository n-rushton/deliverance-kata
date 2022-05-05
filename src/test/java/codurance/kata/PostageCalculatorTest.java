package codurance.kata;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParcelProperties {
    final int LOWER_TIER_HEIGHT = 229;
    final int LOWER_TIER_WIDTH = 162;
    final int LOWER_TIER_DEPTH = 25;

    final int MID_TIER_HEIGHT = 324;

    final int LOWER_TIER_WEIGHT = 60;
    final int MID_TIER_WEIGHT = 500;
    final int TOP_TIER_WEIGHT = 501;
}

class ProvideParamsForMidSizedParcels implements ArgumentsProvider {

    ParcelProperties parcelProps = new ParcelProperties();


    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {

        return Stream.of(
                Arguments.of(parcelProps.MID_TIER_WEIGHT, parcelProps.LOWER_TIER_HEIGHT, parcelProps.LOWER_TIER_WIDTH, parcelProps.LOWER_TIER_DEPTH),
                Arguments.of(parcelProps.LOWER_TIER_WEIGHT, parcelProps.MID_TIER_HEIGHT, parcelProps.LOWER_TIER_WIDTH, parcelProps.LOWER_TIER_DEPTH)
                );
    }
}

public class PostageCalculatorTest {

    ParcelProperties parcelProps = new ParcelProperties();
    private final int LOWER_TIER_HEIGHT = parcelProps.LOWER_TIER_HEIGHT;
    private final int MID_TIER_HEIGHT = parcelProps.MID_TIER_HEIGHT;

    private final int LOWER_TIER_WIDTH = parcelProps.LOWER_TIER_WIDTH;

    private final int LOWER_TIER_DEPTH = parcelProps.LOWER_TIER_DEPTH;


    private final int LOWER_TIER_WEIGHT = parcelProps.LOWER_TIER_WEIGHT;
    private final int TOP_TIER_WEIGHT = parcelProps.TOP_TIER_WEIGHT;


    @Test
    public void apply_small_parcel_pricing_to_a_package_with_lower_tier_dimensions_and_weight() {

        Money expectedCost = new Money(Currency.GBP, BigDecimal.valueOf(120));

        PostageCalculator postageCalculator = new PostageCalculator();
        Money postageCost = postageCalculator.parcelPricing(LOWER_TIER_WEIGHT, LOWER_TIER_HEIGHT, LOWER_TIER_WIDTH, LOWER_TIER_DEPTH, Currency.GBP);

        assertEquals(expectedCost, postageCost);
    }

    @ParameterizedTest
    @ArgumentsSource(ProvideParamsForMidSizedParcels.class)
    public void apply_mid_parcel_pricing_to_a_package_with_lower_tier_dimensions_but_mid_tier_weight(int weight, int height, int width, int depth) {

        BigDecimal expectedPrice = BigDecimal.valueOf(weight * 4);
        Money expectedCost = new Money(Currency.GBP, expectedPrice);

        PostageCalculator postageCalculator = new PostageCalculator();
        Money postageCost = postageCalculator.parcelPricing(weight, height, width, depth, Currency.GBP);

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
