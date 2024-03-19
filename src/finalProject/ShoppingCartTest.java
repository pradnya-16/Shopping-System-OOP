package finalProject;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ShoppingCartTest {
    private User user;
    private ShoppingCart shoppingCart;

    @BeforeEach
    public void setUp() {
        user = new User("testUser", "password", "fname", "lname");
        shoppingCart = new ShoppingCart(user);
    }

    @Test
    public void testAddToCart() {
        Product product = new Product("1", "Smartphone", 499.99);
        shoppingCart.addToCart(product);
        assertEquals(1, shoppingCart.getCartItems().size());
    }

    @Test
    public void testRemoveFromCart() {
        Product product1 = new Product("1", "T-shirt", 19.99);
        Product product2 = new Product("2", "Joggers", 29.99);
        shoppingCart.addToCart(product1);
        shoppingCart.addToCart(product2);
        assertEquals(2, shoppingCart.getCartItems().size());
        shoppingCart.removeFromCart(product1);
        assertEquals(1, shoppingCart.getCartItems().size());
    }
}
