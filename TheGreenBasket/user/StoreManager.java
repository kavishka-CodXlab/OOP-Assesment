package user;

import model.Inventory;
import model.Product;
import java.util.List;

public class StoreManager extends SalesAssistant {

    private List<User> users;

    public StoreManager(String username, String password,
            List<Product> products, List<User> users) {
        super(username, password, products);
        this.users = users;
    }

    @Override
    public String toCSV() {
        return "StoreManager," + username + "," + password;
    }

    @Override
    public void showMenu() {
        super.showMenu();
        System.out.println("4. Create User");
        System.out.println("5. Monitor Inventory");
    }

    public void createUser(String uname, String pwd) {
        users.add(new SalesAssistant(uname, pwd, products));
        System.out.println("Sales Assistant Account Created");
    }

    public void monitorInventory() {
        Inventory.monitorInventory(products);
    }
}
