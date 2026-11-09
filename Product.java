public abstract class Product {

    private final String name;
    private final double price;

    public Product(String name, double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public abstract String getType();

    public abstract double getDiscountRate();

    public double calculateDiscount() {
        return price * getDiscountRate();
    }

    public double calculateFinalPrice() {
        return price - calculateDiscount();
    }

    public void displayInfo() {
        System.out.println("Product Type: " + getType());
        System.out.println("Product: " + name);
        System.out.printf("Original Price: %.2f%n", price);
        System.out.printf("Discount (%.0f%%): %.2f%n", getDiscountRate() * 100, calculateDiscount());
        System.out.printf("Final Price: %.2f%n", calculateFinalPrice());
    }

    @Override
    public String toString() {
        return String.format("%s | %s | Final Price: %.2f", getType(), name, calculateFinalPrice());
    }
}
