file:///C:/Users/P/Desktop/DePaul%20Courses/SE%20450%20Object%20Oriented%20Software%20Development/SE%20450%20Assignments/FinalProject/src/finalProject/Order.java
### java.util.NoSuchElementException: next on empty iterator

occurred in the presentation compiler.

presentation compiler configuration:
Scala version: 3.3.1
Classpath:
<HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\org\scala-lang\scala3-library_3\3.3.1\scala3-library_3-3.3.1.jar [exists ], <HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\org\scala-lang\scala-library\2.13.10\scala-library-2.13.10.jar [exists ]
Options:



action parameters:
offset: 415
uri: file:///C:/Users/P/Desktop/DePaul%20Courses/SE%20450%20Object%20Oriented%20Software%20Development/SE%20450%20Assignments/FinalProject/src/finalProject/Order.java
text:
```scala
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
        return orderedProdu@@cts;
    }
    
    public ShoppingCart getCart() {
        return getCart();
    }
    
    public User getUser() {
        return getUser();
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