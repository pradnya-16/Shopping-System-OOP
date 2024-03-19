package finalProject;

import java.util.List;

public class OrderProcessing {
    private static OrderProcessing instance;
    private ShoppingCartFactory cartFactory;

    OrderProcessing() {
        cartFactory = new ShoppingCartFactory();
    }

    public static OrderProcessing getInstance() {
        if (instance == null) {
            instance = new OrderProcessing();
        }
        return instance;
    }

    public Order createOrder(User user) {
        ShoppingCart cart = cartFactory.createShoppingCart(user);
        return new Order(cart);
    }

    public void addToOrder(Order order, Product product) {
        order.addProduct(product);
    }

    public void displayOrder(Order order) {
    	double total = 0.0;
        System.out.println("Ordered Products:");
        List<Product> orderedProducts = order.getOrderedProducts();
        if (orderedProducts.isEmpty()) {
            System.out.println("No products in the order.");
        } 
        else {
            for (Product product : orderedProducts) {
                System.out.println(product.getProductName() + " - $" + product.getPrice());
            }
        }
        for (Product product : order.getOrderedProducts()) {
            total += product.getPrice();
        }
        System.out.println("Total amount for the order: $" + total);
    }

    public void placeOrder(Order order) {
        System.out.println("Order placed successfully!");
    }
}
