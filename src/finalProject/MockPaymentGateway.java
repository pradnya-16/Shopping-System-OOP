package finalProject;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MockPaymentGateway implements PaymentGateway {
    private static final Map<String, String> cardDatabase = new HashMap<>(); // CardNumber -> CVV

    static {
        // Populate the dummy card database
        cardDatabase.put("1234567890123456", "123");
        cardDatabase.put("9876543210987654", "456");
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