package codurance.kata;

public class ParcelCategorizer {

    public ParcelCategorizer() {
    }

    public Parcel createParcel(int weight, int height, int width, int depth) {
        if (isLargeParcel(weight, height, width, depth)) {
            return new LargeParcel(weight, height, width, depth);
        }

        if (isMediumParcel(weight, height, width, depth)) {
            return new MediumParcel(weight, height, width, depth);
        }

        return new SmallParcel(weight, height, width, depth);
    }


    private boolean isMediumParcel(int weight, int height, int width, int depth) {
        return weight > 60 || height > 229 || width > 162 || depth > 25;
    }

    private boolean isLargeParcel(int weight, int height, int width, int depth) {
        return weight > 500 || height > 324 || width > 229 || depth > 100;
    }

}
