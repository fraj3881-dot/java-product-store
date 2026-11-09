import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void addProducts(List<? super Product> productList) {
        productList.add(new Phone("Samsung", 2000));
        productList.add(new Laptop("HP", 3500));
        productList.add(new Tablet("iPad", 2500));
        productList.add(new Headphones("Sony", 600));
    }

    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();
        addProducts(products);

        System.out.println("=== Store Products ===");
        for (Product product : products) {
            product.displayInfo();
            System.out.println("--------------------");
        }

        System.out.println("=== Store Summary ===");
        System.out.printf("Total Final Prices: %.2f%n", ProductUtils.totalFinalPrice(products));
        Product expensive = ProductUtils.findMostExpensive(products);
        System.out.println("Most Expensive: " + expensive.getName());
        System.out.println();

        ProductStorage<Phone> phoneStorage = new ProductStorage<>();
        phoneStorage.setItem(new Phone("iPhone", 3000));
        System.out.println("=== Stored Phone ===");
        phoneStorage.displayStoredProduct();
        System.out.println();

        ProductStorage<Laptop> laptopStorage = new ProductStorage<>();
        laptopStorage.setItem(new Laptop("Lenovo", 4000));
        System.out.println("=== Stored Laptop ===");
        laptopStorage.displayStoredProduct();
        System.out.println();

        Customer customer = new Customer("Ahmed");
        customer.addToCart(new Phone("Xiaomi", 1500));
        customer.addToCart(new Headphones("JBL", 400));
        customer.addToCart(new Tablet("Lenovo Tab", 1800));
        customer.showReceipt();
    }
}
