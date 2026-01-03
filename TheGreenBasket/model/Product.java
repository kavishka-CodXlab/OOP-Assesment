package model;

public class Product {

    private int id;
    private String name;
    private String category;
    private String supplier;
    private double price;
    private int quantity;

    public Product(int id, String name, String category, String supplier,
            double price, int quantity) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.supplier = supplier;
        this.price = price;
        this.quantity = quantity;
    }

    public String toCSV() {
        return id + "," + name + "," + category + "," + supplier + "," + price + "," + quantity;
    }

    public static Product fromCSV(String csv) {
        String[] parts = csv.split(",");
        return new Product(
                Integer.parseInt(parts[0]),
                parts[1],
                parts[2],
                parts[3],
                Double.parseDouble(parts[4]),
                Integer.parseInt(parts[5]));
    }

    // Getters
    public String getCategory() {
        return category;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return id + " | " + name + " | " + category + " | " + supplier +
                " | Rs." + price + " | Qty: " + quantity;
    }
}
