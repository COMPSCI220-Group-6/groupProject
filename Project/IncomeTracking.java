package Project;
import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class IncomeTracking {

    public static double salary;
    public static double taxes;

    public static void Income() {
        // Ask the user if they want to do the income.
        String response = JOptionPane.showInputDialog("Would you like to do the income? (Enter S for Salary, r for Rate, and n for no):");

        DecimalFormat dfmt = new DecimalFormat("#,###,###,000.00");

        if (response != null && !response.isEmpty()) {
            if (response.equalsIgnoreCase("S")) {
                try {
                    // Ask for the user's salary
                    salary = Double.parseDouble(JOptionPane.showInputDialog("Please enter your salary."));
                    // Calculate and display the taxes
                    taxes = calculateTaxes(salary);
                    JOptionPane.showMessageDialog(null, "Your taxes are: $" + dfmt.format(taxes));
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number for salary.");
                }
            }
            else if (response.equalsIgnoreCase("r"))
            {
                try {
                    // Ask for the user's salary
                    double rate = Double.parseDouble(JOptionPane.showInputDialog("Please enter your rate."));
                    double hourly = Double.parseDouble(JOptionPane.showInputDialog("Please enter your number of hours worked a week."));
                    salary = (rate * hourly) * 52;
                    // Calculate and display the taxes
                    taxes = calculateTaxes(salary);
                    JOptionPane.showMessageDialog(null, "Your taxes are: $" + dfmt.format(taxes));
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number for salary.");
                }
            }
            else if (response.equalsIgnoreCase("n"))
            {
                JOptionPane.showMessageDialog(null, "You chose not to do the income.");
            }
            else
            {
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
    public static double getSalary(){
        return salary;
    }
    public static double getTaxes(){
        return Math.ceil(taxes * 100) / 100;
    }
}
