package codurance.kata;

public class PostageCalculator {
    public Money parcelPricing(int weight, int height, int width, int depth, Currency currency) {
        if (weight > 60) {
            return new Money(currency, weight * 4 * 100);
        }
        return new Money(currency, 12_000);

    }
}
