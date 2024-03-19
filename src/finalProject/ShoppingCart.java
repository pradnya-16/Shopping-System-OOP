package finalProject;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;

public class ShoppingCart {
	private User user;
    private List<Product> cartItems;

    public ShoppingCart(User user) {
        this.user = user;
        this.cartItems = new ArrayList<>();
    }

    public void addToCart(Product product) {
        cartItems.add(product);
        System.out.println("Product added to cart: " + product.getProductName());
    }


    public void removeFromCart(Product product) {
    	cartItems.remove(product);
    	System.out.println("Product Removed from Cart: " + product.getProductName());
    }
    
    public List<Product> getCartItems() {
        return cartItems;
    }
}
