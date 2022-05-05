package codurance.kata;

import java.math.BigDecimal;

public class MediumParcel extends Parcel {

    public MediumParcel(int weight, int height, int width, int depth) {
        super(weight, height, width, depth);
    }

    @Override
    public BigDecimal calculate() {
        return BigDecimal.valueOf(weight * 4L);
    }
}
