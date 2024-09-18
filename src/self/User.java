package self;
import java.util.ArrayList;
import java.util.Scanner;

class User {
    private String username;
    private String userId;
    private String password;
    private String email;
    private ArrayList<Events> cart;

    public User(String username, String userId, String password, String email) {
        this.username = username;
        this.userId = userId;
        this.password = password;
        this.email = email;
        this.cart = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public String getUserId() {
        return userId;
    }

    public void addToCart(Events event) {
        cart.add(event);
    }

    public void viewCart() {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty.");
        } else {
            for (int i = 0; i < cart.size(); i++) {
                System.out.println((i + 1) + ". " + cart.get(i));
            }
        }
    }

    public void removeFromCart(int index) {
        if (index > 0 && index <= cart.size()) {
            cart.remove(index - 1);
            System.out.println("Item removed from cart.");
        } else {
            System.out.println("Invalid index.");
        }
    }

    public static void register(ArrayList<User> users, Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter user ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        users.add(new User(username, userId, password, email));
        System.out.println("User registered successfully.");
    }

    public static User login(ArrayList<User> users, Scanner scanner) {
        System.out.print("Enter user ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        for (User user : users) {
            if (user.getUserId().equals(userId) && user.password.equals(password)) {
                System.out.println("Login successful.");
                return user;
            }
        }
        System.out.println("Invalid user ID or password.");
        return null;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", userId='" + userId + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
