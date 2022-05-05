package codurance.kata;

public class PostageCalculator {

    ParcelFactory parcelFactory = new ParcelFactory();

    public Money parcelPricing(int weight, int height, int width, int depth, Currency currency) {
        Parcel parcel = parcelFactory.createParcel(weight, height, width, depth);

        Money baseParcelCost = parcel.calculate();

        return baseParcelCost.convert(currency);
    }

}
