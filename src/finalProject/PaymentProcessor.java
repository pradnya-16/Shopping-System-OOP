package finalProject;

public class PaymentProcessor {
    private static PaymentProcessor instance;
    private PaymentGateway paymentGateway;

    private PaymentProcessor() {
        // Initialize the payment gateway (you can change this to use a real payment gateway implementation)
        paymentGateway = new MockPaymentGateway();
    }

    public static PaymentProcessor getInstance() {
        if (instance == null) {
            instance = new PaymentProcessor();
        }
        return instance;
    }

    public boolean processPayment(Order order, String cardNumber, String cvv) {
        double totalAmount = calculateTotal(order);

        // Process payment only if the card details are correct
        return paymentGateway.processPayment(totalAmount, cardNumber, cvv);
    }

    private double calculateTotal(Order order) {
        double total = 0.0;
        for (Product product : order.getOrderedProducts()) {
            total += product.getPrice();
        }
        return total;
    }
}