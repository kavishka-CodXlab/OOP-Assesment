import java.io.*;
import java.util.*;
import model.Product;
import user.*;

public class FileHandler {

    private static final String PRODUCT_FILE = "data/products.csv";
    private static final String USER_FILE = "data/users.csv";

    public static void saveProducts(List<Product> products) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(PRODUCT_FILE))) {
            pw.println("ID,Name,Category,Supplier,Price,Quantity"); // Header
            for (Product p : products) {
                pw.println(p.toCSV());
            }
        } catch (IOException e) {
            System.out.println("Error saving products: " + e.getMessage());
        }
    }

    public static List<Product> loadProducts() {
        List<Product> products = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(PRODUCT_FILE))) {
            String line = br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    products.add(Product.fromCSV(line));
                }
            }
        } catch (IOException e) {
            // File might not exist yet, return empty list
        }
        return products;
    }

    public static void saveUsers(List<User> users) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(USER_FILE))) {
            pw.println("Type,Username,Password"); // Header
            for (User u : users) {
                pw.println(u.toCSV());
            }
        } catch (IOException e) {
            System.out.println("Error saving users: " + e.getMessage());
        }
    }

    public static List<User> loadUsers(List<Product> products) {
        List<User> users = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(USER_FILE))) {
            String line = br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    String[] parts = line.split(",");
                    String type = parts[0];
                    String uname = parts[1];
                    String pwd = parts[2];

                    if (type.equals("StoreManager")) {
                        users.add(new StoreManager(uname, pwd, products, users));
                    } else {
                        users.add(new SalesAssistant(uname, pwd, products));
                    }
                }
            }
        } catch (IOException e) {
            // File might not exist yet
        }
        return users;
    }
}
