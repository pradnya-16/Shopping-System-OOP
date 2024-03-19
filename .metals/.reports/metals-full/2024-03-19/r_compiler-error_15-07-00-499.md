file:///C:/Users/P/Desktop/DePaul%20Courses/SE%20450%20Object%20Oriented%20Software%20Development/SE%20450%20Assignments/FinalProject/src/finalProject/OrderProcessing.java
### java.util.NoSuchElementException: next on empty iterator

occurred in the presentation compiler.

presentation compiler configuration:
Scala version: 3.3.1
Classpath:
<HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\org\scala-lang\scala3-library_3\3.3.1\scala3-library_3-3.3.1.jar [exists ], <HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\org\scala-lang\scala-library\2.13.10\scala-library-2.13.10.jar [exists ]
Options:



action parameters:
offset: 841
uri: file:///C:/Users/P/Desktop/DePaul%20Courses/SE%20450%20Object%20Oriented%20Software%20Development/SE%20450%20Assignments/FinalProject/src/finalProject/OrderProcessing.java
text:
```scala
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
        List<Product> ord@@eredProducts = order.getOrderedProducts();
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