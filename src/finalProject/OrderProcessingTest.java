package finalProject;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

public class OrderProcessingTest {
    private OrderProcessing orderProcessing;
    private ShoppingCartFactory cartFactory;

    @BeforeEach
    public void setUp() {
        orderProcessing = OrderProcessing.getInstance();
        cartFactory = new ShoppingCartFactory();
    } 

    @Test
    public void testAddToOrder() {
        User user = new User("Username", "password", "fname", "lname");
        ShoppingCart cart = cartFactory.createShoppingCart(user);
        Order order = new Order(cart);
        Product product = new Product("1", "Smartphone", 499.99);
        orderProcessing.addToOrder(order, product);
        assertEquals(1, order.getOrderedProducts().size());
    }

    @Test
    public void testDisplayOrder() {
        User user = new User("Username", "password", "fname", "lname");
        ShoppingCart cart = cartFactory.createShoppingCart(user);
        Order order = new Order(cart);
        Product product1 = new Product("1", "T-shirt", 19.99);
        Product product2 = new Product("2", "Joggers", 29.99);
        order.addProduct(product1);
        order.addProduct(product2);
        
        // Redirect System.out to capture printed output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        
        orderProcessing.displayOrder(order);
        String printedOutput = outputStream.toString();
        assertTrue(printedOutput.contains("T-shirt - $19.99"));
        assertTrue(printedOutput.contains("Joggers - $29.99"));
    }

    @Test
    public void testPlaceOrder() {
        User user = new User("Username", "password", "fname", "lname");
        ShoppingCart cart = cartFactory.createShoppingCart(user);
        Order order = new Order(cart);
        orderProcessing.placeOrder(order);
        assertDoesNotThrow(() -> orderProcessing.placeOrder(order));
    }
}
