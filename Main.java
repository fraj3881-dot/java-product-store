import java.util.ArrayList;
import java.util.List;

abstract class Product {

    private final String name;
    private final double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public abstract double calculateDiscount();

    public double calculateFinalPrice() {
        return price - calculateDiscount();
    }

    public void displayInfo() {
        System.out.println("Product: " + name);
        System.out.printf("Original Price: %.2f%n", price);
        System.out.printf("Discount: %.2f%n", calculateDiscount());
        System.out.printf("Final Price: %.2f%n", calculateFinalPrice());
    }
}

class Phone extends Product {

    private static final double DISCOUNT_RATE = 0.05;

    public Phone(String name, double price) {
        super(name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * DISCOUNT_RATE;
    }

    @Override
    public void displayInfo() {
        System.out.println("Product Type: Phone");
        super.displayInfo();
    }
}

class Laptop extends Product {

    private static final double DISCOUNT_RATE = 0.10;

    public Laptop(String name, double price) {
        super(name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * DISCOUNT_RATE;
    }

    @Override
    public void displayInfo() {
        System.out.println("Product Type: Laptop");
        super.displayInfo();
    }
}

class Storage<T> {

    private T item;

    public void setItem(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }
}

class ProductStorage<T extends Product> extends Storage<T> {

    public void displayStoredProduct() {
        if (getItem() != null) {
            getItem().displayInfo();
        } else {
            System.out.println("Storage is empty.");
        }
    }
}

public class Main {

    public static void addProducts(List<? super Product> productList) {
        productList.add(new Phone("Samsung", 2000));
        productList.add(new Laptop("HP", 3500));
    }

    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();
        addProducts(products);

        System.out.println("=== Store Products ===");
        for (Product product : products) {
            product.displayInfo();
            System.out.println("--------------------");
        }

        ProductStorage<Phone> phoneStorage = new ProductStorage<>();
        phoneStorage.setItem(new Phone("iPhone", 3000));

        System.out.println("=== Stored Phone ===");
        phoneStorage.displayStoredProduct();

        ProductStorage<Laptop> laptopStorage = new ProductStorage<>();
        laptopStorage.setItem(new Laptop("Lenovo", 4000));

        System.out.println("=== Stored Laptop ===");
        laptopStorage.displayStoredProduct();
    }
}
