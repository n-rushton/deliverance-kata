package codurance.kata;

import java.math.BigDecimal;

public class SmallParcel extends Parcel {

    public SmallParcel(int weight, int height, int width, int depth) {
        super(weight, height, width, depth);
    }


    @Override
    public BigDecimal calculate() {
        return BigDecimal.valueOf(120);
    }
}
