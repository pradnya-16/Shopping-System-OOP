file:///C:/Users/P/Desktop/DePaul%20Courses/SE%20450%20Object%20Oriented%20Software%20Development/SE%20450%20Assignments/FinalProject/src/finalProject/MockPaymentGateway.java
### java.util.NoSuchElementException: next on empty iterator

occurred in the presentation compiler.

presentation compiler configuration:
Scala version: 3.3.1
Classpath:
<HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\org\scala-lang\scala3-library_3\3.3.1\scala3-library_3-3.3.1.jar [exists ], <HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\org\scala-lang\scala-library\2.13.10\scala-library-2.13.10.jar [exists ]
Options:



action parameters:
offset: 399
uri: file:///C:/Users/P/Desktop/DePaul%20Courses/SE%20450%20Object%20Oriented%20Software%20Development/SE%20450%20Assignments/FinalProject/src/finalProject/MockPaymentGateway.java
text:
```scala
package finalProject;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MockPaymentGateway implements PaymentGateway {
    private static final Map<String, String> cardDatabase = new HashMap<>(); // CardNumber -> CVV

    static {
        // Populate the dummy card database
        cardDatabase.put("1234567890123456", "123");
        cardDatabase@@.put("9876543210987654", "456");
    }

    @Override
    public boolean processPayment(double amount, String cardNumber, String cvv) {
        // Check if the entered card details are in the dummy database
        if (cardDatabase.containsKey(cardNumber) && cardDatabase.get(cardNumber).equals(cvv)) {
            // Simulate payment processing
            System.out.println("Processing payment of $" + amount + " using the mock payment gateway.");
            // For simplicity, consider payment successful for any order
            return true;
        } else {
            System.out.println("Incorrect card details. Payment failed.");
            return false;
        }
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