

import java.util.ArrayList;

public class Restaurant {
    private ArrayList<MenuItem> menu;
    private Order currentOrder;

    public Restaurant() {
        menu = new ArrayList<>();
        loadSampleMenu();
        createNewOrder(); 
    }

    private void loadSampleMenu() {
        // Main Dishes (5 items)
        menu.add(new MainDish("M001", "Burger", 125.00));
        menu.add(new MainDish("M002", "Fried Chicken", 150.00));
        menu.add(new MainDish("M003", "Spaghetti", 120.00));
        menu.add(new MainDish("M004", "Pizza", 180.00));
        menu.add(new MainDish("M005", "Steak", 250.00));

        // Beverages (5 items with sizes)
        menu.add(new Beverage("B001", "Coke", 40.00, "Small"));
        menu.add(new Beverage("B002", "Coke", 50.00, "Medium"));
        menu.add(new Beverage("B003", "Coke", 60.00, "Large"));
        menu.add(new Beverage("B004", "Iced Tea", 35.00, "Small"));
        menu.add(new Beverage("B005", "Iced Tea", 45.00, "Large"));

        // Desserts (5 items)
        menu.add(new Dessert("D001", "Ice Cream", 100.00));
        menu.add(new Dessert("D002", "Chocolate Cake", 120.00));
        menu.add(new Dessert("D003", "Fruit Salad", 80.00));
        menu.add(new Dessert("D004", "Leche Flan", 90.00));
        menu.add(new Dessert("D005", "Brownies", 110.00));
    }

    public ArrayList<MenuItem> getMenuByCategory(String category) {
        ArrayList<MenuItem> result = new ArrayList<>();
        for (MenuItem item : menu) {
            if (item.getCategory().equals(category)) {
                result.add(item);
            }
        }
        return result;
    }

    public ArrayList<MenuItem> getAllMenu() {
        return new ArrayList<>(menu);
    }

    public void createNewOrder() {
        String orderId = "ORD-" + System.currentTimeMillis();
        currentOrder = new Order(orderId);
    }

    public void addToCurrentOrder(MenuItem item, int quantity) {
        if (currentOrder == null) createNewOrder();
        OrderItem orderItem = new OrderItem(item, quantity);
        currentOrder.addItem(orderItem);
    }

    public void finalizeCurrentOrder() {
        if (currentOrder != null && !currentOrder.getItems().isEmpty()) {
            createNewOrder();
        }
    }

    public Order getCurrentOrder() {
        return currentOrder;
    }
}