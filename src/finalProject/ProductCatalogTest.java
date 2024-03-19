package finalProject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductCatalogTest {
    private ProductCatalog productCatalog;

    @BeforeEach
    public void setUp() {
        productCatalog = new ProductCatalog();
    }

    @Test
    public void testAddProductToCatalog() {
        Product product = new Product("1", "T-shirt", 19.99);
        productCatalog.addProduct(product);
        assertEquals(1, productCatalog.getAllProducts().size());
    }

    @Test
    public void testGetProductById() {
        Product product1 = new Product("1", "T-shirt", 19.99);
        Product product2 = new Product("2", "Jogger", 29.99);
        productCatalog.addProduct(product1);
        productCatalog.addProduct(product2);
        assertEquals(product1, productCatalog.getProductById("1"));
        assertEquals(product2, productCatalog.getProductById("2"));
    }
}
