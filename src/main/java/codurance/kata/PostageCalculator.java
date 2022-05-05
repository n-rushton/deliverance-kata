package codurance.kata;

import java.math.BigDecimal;

public class PostageCalculator {

    ParcelFactory parcelFactory = new ParcelFactory();

    public Money parcelPricing(int weight, int height, int width, int depth, Currency currency) {
        Parcel parcel = parcelFactory.createParcel(weight, height, width, depth);

        Money parcelCost = parcel.calculate();

        if (currency.equals(Currency.EUR)) {
            parcelCost = new Money(Currency.EUR, parcelCost.amount().add(BigDecimal.valueOf(20)).multiply(BigDecimal.valueOf(1.19)));
        }

        return parcelCost;
    }

}
