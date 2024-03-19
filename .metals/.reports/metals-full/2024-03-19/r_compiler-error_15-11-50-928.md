file:///C:/Users/P/Desktop/DePaul%20Courses/SE%20450%20Object%20Oriented%20Software%20Development/SE%20450%20Assignments/FinalProject/src/finalProject/Main.java
### java.util.NoSuchElementException: next on empty iterator

occurred in the presentation compiler.

presentation compiler configuration:
Scala version: 3.3.1
Classpath:
<HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\org\scala-lang\scala3-library_3\3.3.1\scala3-library_3-3.3.1.jar [exists ], <HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\org\scala-lang\scala-library\2.13.10\scala-library-2.13.10.jar [exists ]
Options:



action parameters:
offset: 2241
uri: file:///C:/Users/P/Desktop/DePaul%20Courses/SE%20450%20Object%20Oriented%20Software%20Development/SE%20450%20Assignments/FinalProject/src/finalProject/Main.java
text:
```scala
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
        OrderProcessing orderProcessing = OrderProc@@essing.getInstance();
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

```



#### Error stacktrace:

```
scala.collection.Iterator$$anon$19.next(Iterator.scala:973)
	scala.collection.Iterator$$anon$19.next(Iterator.scala:971)
	scala.collection.mutable.MutationTracker$CheckedIterator.next(MutationTracker.scala:76)
	scala.collection.IterableOps.head(Iterable.scala:222)
	scala.collection.IterableOps.head$(Iterable.scala:222)
	scala.collection.AbstractIterable.head(Iterable.scala:933)
	dotty.tools.dotc.interactive.InteractiveDriver.run(InteractiveDriver.scala:168)
	scala.meta.internal.pc.MetalsDriver.run(MetalsDriver.scala:45)
	scala.meta.internal.pc.HoverProvider$.hover(HoverProvider.scala:34)
	scala.meta.internal.pc.ScalaPresentationCompiler.hover$$anonfun$1(ScalaPresentationCompiler.scala:352)
```
#### Short summary: 

java.util.NoSuchElementException: next on empty iterator