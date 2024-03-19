package finalProject;

import java.util.ArrayList;
import java.util.List;

public class Order {
	private List<Product> orderedProducts;

    public Order(ShoppingCart cart) {
        this.orderedProducts = new ArrayList<>();
    }

    public void addProduct(Product product) {
        orderedProducts.add(product);
    }

    public List<Product> getOrderedProducts() {
        return orderedProducts;
    }
    
    public ShoppingCart getCart() {
        return getCart();
    }
    
    public User getUser() {
        return getUser();
    }
}
