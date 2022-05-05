package codurance.kata;

public class PostageCalculator {

    ParcelFactory parcelFactory = new ParcelFactory();
    CurrencyConverter currencyConverter = new CurrencyConverter();

    public Money parcelPricing(int weight, int height, int width, int depth, Currency currency) {
        Parcel parcel = parcelFactory.createParcel(weight, height, width, depth);

        Money baseParcelCost = parcel.calculate();

        return currencyConverter.convertFromGBP(baseParcelCost, currency);
    }

}
