public class ProductStorage<T extends Product> extends Storage<T> {

    public void displayStoredProducts() {
        if (isEmpty()) {
            System.out.println("Storage is empty.");
            return;
        }
        for (T product : getItems()) {
            product.displayInfo();
            System.out.println("--------------------");
        }
    }

    public double getTotalValue() {
        double total = 0;
        for (T product : getItems()) {
            total += product.calculateFinalPrice();
        }
        return total;
    }

    public T findMostExpensive() {
        if (isEmpty()) {
            return null;
        }
        T expensive = null;
        for (T product : getItems()) {
            if (expensive == null || product.getPrice() > expensive.getPrice()) {
                expensive = product;
            }
        }
        return expensive;
    }
}
