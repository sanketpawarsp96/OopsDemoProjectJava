package self;
import java.util.ArrayList;
import java.util.Scanner;

class Admin {
    private String adminId;
    private String passkey;
    

    public Admin(String adminId, String passkey) {
        this.adminId = adminId;
        this.passkey = passkey;
    }

    public static Admin login(Admin admin, Scanner scanner) {
        System.out.print("Enter admin ID: ");
        String adminId = scanner.nextLine();
        System.out.print("Enter passkey: ");
        String passkey = scanner.nextLine();

        if (admin.adminId.equals(adminId) && admin.passkey.equals(passkey)) {
            System.out.println("Login successful.");
            return admin;
        } else {
            System.out.println("Invalid admin ID or passkey.");
            return null;
        }
    }

    public void deleteUser(ArrayList<User> users, Scanner scanner) {
        System.out.print("Enter user ID to delete: ");
        String userId = scanner.nextLine();

        User userToDelete = null;
        for (User user : users) {
            if (user.getUserId().equals(userId)) {
                userToDelete = user;
                break;
            }
        }

        if (userToDelete != null) {
            users.remove(userToDelete);
            System.out.println("User deleted successfully.");
        } else {
            System.out.println("User not found.");
        }
    }

    public void viewUsers(ArrayList<User> users) {
        if (users.isEmpty()) {
            System.out.println("No users available.");
        } else {
            for (User user : users) {
                System.out.println(user);
            }
        }
    }
}
