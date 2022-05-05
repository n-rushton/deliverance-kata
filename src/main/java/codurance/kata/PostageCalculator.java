package codurance.kata;

public class PostageCalculator {

    ParcelCategorizer parcelCategorizer = new ParcelCategorizer();
    CurrencyConverter currencyConverter = new CurrencyConverter();

    public Money parcelPricing(int weight, int height, int width, int depth, Currency currency) {
        Parcel parcel = parcelCategorizer.createParcel(weight, height, width, depth);

        Money baseParcelCost = parcel.calculate();

        return currencyConverter.convertFromGBP(baseParcelCost, currency);
    }

}
