public class Laptop extends Product {

    private static final double DISCOUNT_RATE = 0.10;

    private final int ramGB;

    public Laptop(String name, double price, int ramGB) {
        super(name, price);
        this.ramGB = ramGB;
    }

    public int getRamGB() {
        return ramGB;
    }

    @Override
    public String getType() {
        return "Laptop";
    }

    @Override
    public double getDiscountRate() {
        return DISCOUNT_RATE;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("RAM: " + ramGB + " GB");
    }
}
