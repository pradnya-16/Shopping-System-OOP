package finalProject;

import java.util.ArrayList;
import java.util.List;

public class ProductCatalog {
	private List<Product> productList;

    public ProductCatalog() {
        productList = new ArrayList<>();
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public Product getProductById(String productId) {
        for (Product product : productList) {
            if (product.getProductId().equals(productId)) {
                return product;
            }
        }
        return null; // Product not found
    }
    
    public void displayCatalog() {
        if (productList.isEmpty()) {
            System.out.println("The catalog is empty.");
        } else {
            System.out.println("Product Catalog:");
            for (Product product : productList) {
                System.out.println(product);
            }
        }
        
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(productList);
    }
}
