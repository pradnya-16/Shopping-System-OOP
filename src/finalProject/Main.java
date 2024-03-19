package finalProject;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
    	LoggerManager.logInfo("Application started");
    	
    	
        UserAuthentication userAuthentication = UserAuthentication.getInstance();
        Scanner scanner = new Scanner(System.in);

        // User registration
        System.out.println("Welcome to the Shopping System!");
        System.out.println("Please register to continue.");
        System.out.println("Enter a First Name:");
        String fname = scanner.nextLine();
        System.out.println("Enter a Last Name:");
        String lname = scanner.nextLine();
        System.out.println("Enter a username:");
        String username = scanner.nextLine();
        System.out.println("Enter a password:");
        String password = scanner.nextLine();
        userAuthentication.registerUser(username, password, fname, lname);
        System.out.println("Registration successful.");

        

        // User authentication
        boolean isAuthenticated = false;
        while (!isAuthenticated) {
            System.out.println("Please login to continue.");
            System.out.println("Enter your username:");
            String inputUsername = scanner.nextLine();
            System.out.println("Enter your password:");
            String inputPassword = scanner.nextLine();
            isAuthenticated = userAuthentication.authenticateUser(inputUsername, inputPassword);
            if (!isAuthenticated) {
                System.out.println("Invalid username or password. Please try again.");
            }
        }
        System.out.println("Login successful.");

        // Create a user object for the logged-in user
        User user = new User(fname, lname, username, password);

        // Product catalog
        ProductCatalog productCatalog = new ProductCatalog();
        productCatalog.addProduct(new Product("1", "T-shirt", 19.99));
        productCatalog.addProduct(new Product("2", "Joggers", 29.99));
        

        // Display product catalog
        productCatalog.displayCatalog();

        // Order processing
        OrderProcessing orderProcessing = OrderProcessing.getInstance();
        Order order = orderProcessing.createOrder(user);

        // Allow the user to add products to the order
        boolean continueShopping = true;
        while (continueShopping) {
            System.out.println("\nEnter the product ID to add to your order (or type 'Buy' to finish):");
            String productId = scanner.nextLine();

            if (productId.equalsIgnoreCase("Buy")) {
                continueShopping = false;
            } else {
                Product selectedProduct = productCatalog.getProductById(productId);

                if (selectedProduct != null) {
                    orderProcessing.addToOrder(order, selectedProduct);
                    System.out.println("Added " + selectedProduct.getProductName() + " to your order.");
                } else {
                    System.out.println("Invalid product ID. Please try again.");
                }
            }
        }

        // Display the final order
        System.out.println("\nYour Order:");
        orderProcessing.displayOrder(order);
        
        
        // Payment processing
        PaymentProcessor paymentProcessor = PaymentProcessor.getInstance();
        boolean continuePayment = true;
        while (continuePayment) {
        	if (!order.getOrderedProducts().isEmpty()) {
        		// Ask for card details
        		System.out.println("\nPlease enter your card number:");
        		String cardNumber = scanner.nextLine();

        		System.out.println("Please enter your CVV:");
        		String cvv = scanner.nextLine();

        		// Process payment for the order
        		boolean isPaymentSuccessful = paymentProcessor.processPayment(order, cardNumber, cvv);

        		if (isPaymentSuccessful) {
        			System.out.println("Payment successful! Thank you for your order.");
        			continuePayment = false; // Exit payment loop
        		} 
        		else {
        			System.out.println("Payment failed. Do you want to try another method? (y/n)");
        			String tryAgain = scanner.nextLine().toLowerCase();

        			if (!tryAgain.equals("y")) {
        				continueShopping = true;
        				while (continueShopping) {
        					// Display product catalog
        					productCatalog.displayCatalog();

        					// Allow the user to add products to the order
        					System.out.println("\nEnter the product ID to add to your order (or type 'Buy' to finish shopping):");
        					String newProductId = scanner.nextLine();

        					if (newProductId.equalsIgnoreCase("Buy")) {
        						continueShopping = false;
        						break;
        					}

        					Product newSelectedProduct = productCatalog.getProductById(newProductId);

        					if (newSelectedProduct != null) {
        						orderProcessing.addToOrder(order, newSelectedProduct);
        						System.out.println("Added " + newSelectedProduct.getProductName() + " to your order.");
        					} 
        					else {
                            System.out.println("Invalid product ID. Please try again.");
        					}
        				}
        				continuePayment = true;
        			}
        		}
        	}
        	else {
        		System.out.println("No products in the order. Payment not required.");
                continuePayment = false;
        	} 
        }
        LoggerManager.logInfo("Application finished");
    }
}
