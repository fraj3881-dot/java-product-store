public class Phone extends Product {

    private static final double DISCOUNT_RATE = 0.05;

    private final int storageGB;

    public Phone(String name, double price, int storageGB) {
        super(name, price);
        this.storageGB = storageGB;
    }

    public int getStorageGB() {
        return storageGB;
    }

    @Override
    public String getType() {
        return "Phone";
    }

    @Override
    public double getDiscountRate() {
        return DISCOUNT_RATE;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Storage: " + storageGB + " GB");
    }
}
