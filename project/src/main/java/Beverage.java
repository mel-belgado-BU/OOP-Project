public class Beverage extends MenuItem {
    private String size; // "Small", "Medium", "Large"

    public Beverage(String id, String name, double price, String size) {
        super(id, name, price, "Beverage");
        this.size = size;
    }

    public String getSize() { return size; }

    @Override
    public String toString() {
        return super.getName() + " (" + size + ") - P" + super.getPrice();
    }
}