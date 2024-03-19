package finalProject;

public interface PaymentGateway {
    boolean processPayment(double amount, String cardNumber, String cvv);
}
