import java.util.ArrayList;

public class Calculator {
    ArrayList<Product> products = new ArrayList<>();
    double sum;

    public void addProduct(String name, double price) {
        products.add(new Product(name, price));
        sum += price;
        System.out.println("Товар добавлен успешно!\n");
    }

    public void printAll(int guests) {
        System.out.println("\n--------------------------------------------------------");
        System.out.println("Добавленные товары:");
        for (Product product: products) {
            System.out.println(product.name + ": " + product.price + " " + Formatter.rublesFormat(product.price));
        }
        double dividedPrice = sum / guests;
        System.out.println("В итоге, каждый должен скинуть " + Formatter.priceFormat(dividedPrice) + " " + Formatter.rublesFormat(dividedPrice));
    }
}
