package codurance.kata;

public class PostageCalculator {

    ParcelFactory parcelFactory = new ParcelFactory();

    public Money parcelPricing(int weight, int height, int width, int depth, Currency currency) {
        Parcel parcel = parcelFactory.createParcel(weight, height, width, depth);

        Money parcelCost = parcel.calculate();

        if (currency.equals(Currency.EUR) || currency.equals(Currency.USD)) {
            parcelCost = parcelCost.convert(currency);
        }

        return parcelCost;
    }

}
