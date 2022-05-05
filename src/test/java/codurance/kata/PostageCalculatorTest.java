package codurance.kata;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PostageCalculatorTest {

    ParcelProperties parcelProps = new ParcelProperties();

    @Test
    public void apply_small_parcel_pricing_to_a_package_with_lower_tier_dimensions_and_weight() {

        Money expectedCost = new Money(Currency.GBP, BigDecimal.valueOf(120));

        PostageCalculator postageCalculator = new PostageCalculator();
        Money postageCost = postageCalculator.parcelPricing(
                parcelProps.LOWER_TIER_WEIGHT,
                parcelProps.LOWER_TIER_HEIGHT,
                parcelProps.LOWER_TIER_WIDTH,
                parcelProps.LOWER_TIER_DEPTH,
                Currency.GBP);

        assertEquals(expectedCost, postageCost);
    }

    @ParameterizedTest
    @ArgumentsSource(ParamsForMidSizedParcels.class)
    public void apply_mid_parcel_pricing(int weight, int height, int width, int depth) {

        BigDecimal expectedPrice = BigDecimal.valueOf(weight * 4);
        Money expectedCost = new Money(Currency.GBP, expectedPrice);

        PostageCalculator postageCalculator = new PostageCalculator();
        Money postageCost = postageCalculator.parcelPricing(weight, height, width, depth, Currency.GBP);

        assertEquals(expectedCost, postageCost);
    }

    @ParameterizedTest
    @ArgumentsSource(ParamsForLargeParcelsWeightBasedPricing.class)
    public void apply_large_parcel_weight_based_pricing_strategy(int weight, int height, int width, int depth) {

        BigDecimal expectedPrice = BigDecimal.valueOf(weight * 6);
        Money expectedCost = new Money(Currency.GBP, expectedPrice);

        PostageCalculator postageCalculator = new PostageCalculator();
        Money postageCost = postageCalculator.parcelPricing(weight, height, width, depth, Currency.GBP);

        assertEquals(expectedCost, postageCost);
    }

    @ParameterizedTest
    @ArgumentsSource(ParamsForLargeParcelsDimensionBasedPricing.class)
    public void apply_large_parcel_dimension_based_pricing_strategy(int weight, int height, int width, int depth) {

        BigDecimal expectedPrice = BigDecimal.valueOf(height * width * depth * 6 * 0.001);
        Money expectedCost = new Money(Currency.GBP, expectedPrice);

        PostageCalculator postageCalculator = new PostageCalculator();
        Money postageCost = postageCalculator.parcelPricing(weight, height, width, depth, Currency.GBP);

        assertEquals(expectedCost, postageCost);
    }

}


class ParcelProperties {
    final int LOWER_TIER_HEIGHT = 229;
    final int LOWER_TIER_WIDTH = 162;
    final int LOWER_TIER_DEPTH = 25;

    final int MID_TIER_HEIGHT = 324;
    final int MID_TIER_WIDTH = 229;
    final int MID_TIER_DEPTH = 100;

    final int UPPER_TIER_HEIGHT = 325;
    final int UPPER_TIER_WIDTH = 230;
    final int UPPER_TIER_DEPTH = 101;

    final int LOWER_TIER_WEIGHT = 60;
    final int MID_TIER_WEIGHT = 500;
    final int TOP_TIER_WEIGHT = 501;
}

class ParamsForMidSizedParcels implements ArgumentsProvider {

    ParcelProperties parcelProps = new ParcelProperties();

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {

        return Stream.of(
                Arguments.of(parcelProps.MID_TIER_WEIGHT, parcelProps.LOWER_TIER_HEIGHT, parcelProps.LOWER_TIER_WIDTH, parcelProps.LOWER_TIER_DEPTH),
                Arguments.of(parcelProps.LOWER_TIER_WEIGHT, parcelProps.MID_TIER_HEIGHT, parcelProps.LOWER_TIER_WIDTH, parcelProps.LOWER_TIER_DEPTH),
                Arguments.of(parcelProps.LOWER_TIER_WEIGHT, parcelProps.LOWER_TIER_HEIGHT, parcelProps.MID_TIER_WIDTH, parcelProps.LOWER_TIER_DEPTH),
                Arguments.of(parcelProps.LOWER_TIER_WEIGHT, parcelProps.LOWER_TIER_HEIGHT, parcelProps.LOWER_TIER_WIDTH, parcelProps.MID_TIER_DEPTH)
        );
    }
}

class ParamsForLargeParcelsWeightBasedPricing implements ArgumentsProvider {
    ParcelProperties parcelProps = new ParcelProperties();

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {

        return Stream.of(
                Arguments.of(parcelProps.TOP_TIER_WEIGHT, 10, 20, 10),
                Arguments.of(parcelProps.MID_TIER_WEIGHT, parcelProps.UPPER_TIER_HEIGHT, 20, 10),
                Arguments.of(parcelProps.MID_TIER_WEIGHT, 10, parcelProps.UPPER_TIER_WIDTH, 10),
                Arguments.of(parcelProps.MID_TIER_WEIGHT, 10, 20, parcelProps.UPPER_TIER_DEPTH),
                Arguments.of(parcelProps.LOWER_TIER_WEIGHT, 10, 20, parcelProps.UPPER_TIER_DEPTH)
        );
    }
}


class ParamsForLargeParcelsDimensionBasedPricing implements ArgumentsProvider {
    ParcelProperties parcelProps = new ParcelProperties();

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {

        return Stream.of(
                Arguments.of(parcelProps.TOP_TIER_WEIGHT, parcelProps.LOWER_TIER_HEIGHT, parcelProps.LOWER_TIER_WIDTH, parcelProps.LOWER_TIER_DEPTH),
                Arguments.of(parcelProps.MID_TIER_WEIGHT, 2000, parcelProps.LOWER_TIER_WIDTH, parcelProps.LOWER_TIER_DEPTH),
                Arguments.of(parcelProps.MID_TIER_WEIGHT, parcelProps.LOWER_TIER_HEIGHT, 2000, parcelProps.LOWER_TIER_DEPTH),
                Arguments.of(parcelProps.MID_TIER_WEIGHT, parcelProps.LOWER_TIER_HEIGHT, parcelProps.LOWER_TIER_WIDTH, 2000)

        );
    }
}
