import user.*;
import model.*;
import java.util.*;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Product> products = FileHandler.loadProducts();
        List<User> users = FileHandler.loadUsers(products);

        // Ensure at least one admin exists if file is empty
        if (users.isEmpty()) {
            users.add(new StoreManager("admin", "admin123", products, users));
            FileHandler.saveUsers(users);
        }

        System.out.println("=== Welcome to The Green Basket ===");
        User currentUser = null;

        while (currentUser == null) {
            System.out.print("Username: ");
            String uname = sc.nextLine();
            System.out.print("Password: ");
            String pwd = sc.nextLine();

            for (User u : users) {
                if (u.getUsername().equals(uname) && u.getPassword().equals(pwd)) {
                    currentUser = u;
                    break;
                }
            }

            if (currentUser == null) {
                System.out.println("❌ Invalid Credentials. Try Again.");
            }
        }

        System.out.println("\n✅ Login Successful! Welcome, " + currentUser.getUsername());

        int choice;
        do {
            System.out.println("\n--- Menu ---");
            currentUser.showMenu();
            System.out.println("0. Exit");
            System.out.print("Select Option: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    ((SalesAssistant) currentUser).viewProducts();
                    break;
                case 2:
                    ((SalesAssistant) currentUser).addProduct(sc);
                    break;
                case 3:
                    System.out.print("Enter Category: ");
                    ((SalesAssistant) currentUser).searchByCategory(sc.nextLine());
                    break;
                case 4:
                    if (currentUser instanceof StoreManager) {
                        System.out.print("New Username: ");
                        String u = sc.nextLine();
                        System.out.print("New Password: ");
                        String p = sc.nextLine();
                        ((StoreManager) currentUser).createUser(u, p);
                    } else {
                        System.out.println("❌ Access Denied.");
                    }
                    break;
                case 5:
                    if (currentUser instanceof StoreManager) {
                        ((StoreManager) currentUser).monitorInventory();
                    } else {
                        System.out.println("❌ Access Denied.");
                    }
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("❌ Invalid Option.");
            }

            FileHandler.saveProducts(products);
            FileHandler.saveUsers(users);

        } while (choice != 0);
    }
}
