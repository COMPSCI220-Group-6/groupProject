package Project;
import javax.swing.JOptionPane;

public class IncomeTracking {

    public static void Income() {
        // Ask the user if they want to do the income.
        String response = JOptionPane.showInputDialog("Would you like to do the income? (Enter y for yes, and n for no):");

        if (response != null && !response.isEmpty()) {
            if (response.equalsIgnoreCase("y")) {
                try {
                    // Ask for the user's salary
                    double salary = Double.parseDouble(JOptionPane.showInputDialog("Please enter your salary."));
                    // Calculate and display the taxes
                    double taxes = calculateTaxes(salary);
                    JOptionPane.showMessageDialog(null, "Your taxes are: $" + taxes);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number for salary.");
                }
            } else if (response.equalsIgnoreCase("n")) {
                JOptionPane.showMessageDialog(null, "You chose not to do the income.");
            } else {
                JOptionPane.showMessageDialog(null, "Invalid response. Please enter 'y' for yes or 'n' for no.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Hello, you didn't enter a response.");
        }
    }

    // Method to calculate taxes (this is just a placeholder example)
    private static double calculateTaxes(double salary) {
        return salary * 0.29; // Example: 20% tax rate
    }

    //public static void main(String[] args) {Income(); // Call the Income method}
}
