import javax.swing.SwingUtilities;

public class Project {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new RestaurantGUI();
        });
    }
}