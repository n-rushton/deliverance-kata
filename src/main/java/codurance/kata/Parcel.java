package codurance.kata;

public abstract class Parcel implements ParcelPricing {

    protected final int weight;
    protected final int height;
    protected final int width;
    protected final int depth;

    public Parcel(int weight, int height, int width, int depth) {
        this.weight = weight;
        this.height = height;
        this.width = width;
        this.depth = depth;
    }
}
