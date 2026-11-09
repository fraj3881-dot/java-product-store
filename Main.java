import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void addProducts(List<? super Product> productList) {
        productList.add(new Phone("Samsung", 2000, 128));
        productList.add(new Laptop("HP", 3500, 16));
        productList.add(new Phone("Xiaomi", 1200, 256));
        productList.add(new Laptop("Dell", 4200, 32));
    }

    public static double totalFinalPrice(List<? extends Product> productList) {
        double total = 0;
        for (Product product : productList) {
            total += product.calculateFinalPrice();
        }
        return total;
    }

    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();
        addProducts(products);

        System.out.println("=== Store Products ===");
        for (Product product : products) {
            product.displayInfo();
            System.out.println("--------------------");
        }

        products.sort(Comparator.comparingDouble(Product::calculateFinalPrice));
        System.out.println("=== Sorted By Final Price (Low to High) ===");
        for (Product product : products) {
            System.out.println(product);
        }

        System.out.println();
        System.out.printf("Total Final Price: %.2f%n", totalFinalPrice(products));
        System.out.println();

        ProductStorage<Phone> phoneStorage = new ProductStorage<>();
        phoneStorage.addItem(new Phone("iPhone", 3000, 256));
        phoneStorage.addItem(new Phone("Pixel", 2500, 128));

        System.out.println("=== Stored Phones ===");
        phoneStorage.displayStoredProducts();
        System.out.printf("Phones Total Value: %.2f%n", phoneStorage.getTotalValue());
        System.out.println("Most Expensive Phone: " + phoneStorage.findMostExpensive().getName());
        System.out.println();

        ProductStorage<Laptop> laptopStorage = new ProductStorage<>();
        laptopStorage.addItem(new Laptop("Lenovo", 4000, 16));
        laptopStorage.addItem(new Laptop("Asus", 3800, 8));
        laptopStorage.addItem(new Laptop("MacBook", 6500, 24));

        System.out.println("=== Stored Laptops ===");
        laptopStorage.displayStoredProducts();
        System.out.printf("Laptops Total Value: %.2f%n", laptopStorage.getTotalValue());
        System.out.println("Most Expensive Laptop: " + laptopStorage.findMostExpensive().getName());
        System.out.println();

        ProductStorage<Phone> emptyStorage = new ProductStorage<>();
        System.out.println("=== Empty Storage ===");
        emptyStorage.displayStoredProducts();
    }
}
