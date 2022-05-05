package codurance.kata;

import java.math.BigDecimal;

public class PostageCalculator {

    ParcelFactory parcelFactory = new ParcelFactory();

    public Money parcelPricing(int weight, int height, int width, int depth, Currency currency) {
        Parcel parcel = parcelFactory.createParcel(weight, height, width, depth);

        BigDecimal parcelCost = parcel.calculate();

        return new Money(currency, parcelCost);
    }

}
