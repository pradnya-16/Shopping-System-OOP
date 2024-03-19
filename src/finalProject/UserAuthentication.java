package finalProject;

import java.util.HashMap;
import java.util.Map;

public class UserAuthentication {
	private static UserAuthentication instance;
    private Map<String, User> userDatabase;

    private UserAuthentication() {
        userDatabase = new HashMap<>();
    }
 
    public static UserAuthentication getInstance() {
        if (instance == null) {
            instance = new UserAuthentication();
        }
        return instance;
    }

    public void registerUser(String username, String password, String fname, String lname) {
        if (!userDatabase.containsKey(username)) {
            User newUser = new User(username, password, fname, lname);
            userDatabase.put(username, newUser);
            System.out.println("User registered successfully.");
        } else {
            System.out.println("Username already exists. Please choose another one.");
        }
    }

    public boolean authenticateUser(String username, String password) {
        if (userDatabase.containsKey(username)) {
            User user = userDatabase.get(username);
            return user.getPassword().equals(password);
        }
        return false;
    }
}
