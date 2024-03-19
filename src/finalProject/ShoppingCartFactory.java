package finalProject;

public class ShoppingCartFactory {
	public ShoppingCart createShoppingCart(User user) {
        return new ShoppingCart(user);
    }
}
