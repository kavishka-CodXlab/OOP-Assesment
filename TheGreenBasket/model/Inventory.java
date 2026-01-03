package model;

import java.util.List;

public class Inventory {

    public static void monitorInventory(List<Product> products) {
        System.out.println("\n================ INVENTORY REPORT ================");
        System.out.printf("%-5s | %-15s | %-15s | %-8s | %-8s\n", "ID", "Name", "Category", "Price", "Qty");
        System.out.println("--------------------------------------------------");

        double totalValue = 0;
        int totalQty = 0;
        int lowStockCount = 0;

        for (Product p : products) {
            System.out.printf("%-5s | %-15s | %-15s | Rs.%-6.2f | %-8d %s\n",
                    "P" + products.indexOf(p), p.getName(), p.getCategory(), p.getPrice(), p.getQuantity(),
                    (p.getQuantity() < 5 ? "⚠ LOW STOCK" : ""));

            totalValue += p.getPrice() * p.getQuantity();
            totalQty += p.getQuantity();
            if (p.getQuantity() < 5)
                lowStockCount++;
        }

        System.out.println("--------------------------------------------------");
        System.out.println("Total Products in System  : " + products.size());
        System.out.println("Total Items in Stock      : " + totalQty);
        System.out.println("Total Inventory Value     : Rs." + String.format("%.2f", totalValue));
        System.out.println("Low Stock Alerts          : " + lowStockCount);
        System.out.println("==================================================\n");
    }

    public static void checkLowStock(List<Product> products) {
        for (Product p : products) {
            if (p.getQuantity() < 5) {
                System.out.println("⚠ Low Stock Alert: " + p.getName() + " (Only " + p.getQuantity() + " left)");
            }
        }
    }
}
