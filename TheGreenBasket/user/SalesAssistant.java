package user;

import model.Product;
import java.util.List;
import java.util.Scanner;

public class SalesAssistant extends User {

    protected List<Product> products;

    public SalesAssistant(String username, String password,
            List<Product> products) {
        super(username, password);
        this.products = products;
    }

    @Override
    public String toCSV() {
        return "SalesAssistant," + username + "," + password;
    }

    @Override
    public void showMenu() {
        System.out.println("1. View Products");
        System.out.println("2. Add Product");
        System.out.println("3. Search by Category");
    }

    public void viewProducts() {
        for (Product p : products) {
            System.out.println(p);
        }
    }

    public void addProduct(Scanner sc) {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Category: ");
        String category = sc.nextLine();

        System.out.print("Enter Supplier: ");
        String supplier = sc.nextLine();

        System.out.print("Enter Price: ");
        double price = sc.nextDouble();

        System.out.print("Enter Quantity: ");
        int qty = sc.nextInt();

        products.add(new Product(id, name, category, supplier, price, qty));
        System.out.println("✅ Product Added Successfully");
    }

    public void searchByCategory(String cat) {
        for (Product p : products) {
            if (p.getCategory().equalsIgnoreCase(cat)) {
                System.out.println(p);
            }
        }
    }
}
