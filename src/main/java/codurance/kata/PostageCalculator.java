package codurance.kata;

public class PostageCalculator {
    public Money parcelPricing(int weight, int height, int width, int depth, Currency currency) {
        return new Money(currency, 12_000);
    }
}
