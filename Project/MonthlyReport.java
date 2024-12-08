package Project;

import javax.swing.JOptionPane;

public class MonthlyReport {

    private double salary = 0.0;
    private double taxes = 0.0;
    private double savingsGoal = 0.0;
    private double totalExpenses = 0.0;

    // Method to input total expenses directly
    public void inputTotalExpenses() {
        try {
            totalExpenses = Double.parseDouble(JOptionPane.showInputDialog("Enter your total expenses:"));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number for total expenses.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Retrieve salary and calculate taxes
    public void calculateSalaryAndTaxes() {
        String response = JOptionPane.showInputDialog("Would you like to input your salary? (y/n):");

        if (response != null && response.equalsIgnoreCase("y")) {
            try {
                salary = Double.parseDouble(JOptionPane.showInputDialog("Enter your salary:"));
                taxes = salary * 0.29; // Assuming a 29% tax rate
                JOptionPane.showMessageDialog(null, "Your calculated taxes are: $" + taxes);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number for salary.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Salary input is Zero.");
        }
    }

    // Retrieve and calculate savings goal
    public void calculateSavingsGoal() {
        try {
            savingsGoal = Double.parseDouble(JOptionPane.showInputDialog("Enter your savings goal:"));
            JOptionPane.showMessageDialog(null, "Your savings goal is: $" + savingsGoal);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number for savings goal.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Show expenses along with salary, taxes, and savings goal
    public void showExpenses() {
        calculateSalaryAndTaxes();
        inputTotalExpenses();
        calculateSavingsGoal();

        double remainingBalance = salary - taxes - totalExpenses - savingsGoal;

        // Display the calculated data
        JOptionPane.showMessageDialog(null,
                "Monthly Report:" +
                        "\n\nExpenses this Month: $" + totalExpenses +
                        "\nSalary: $" + salary +
                        "\nTaxes: $" + taxes +
                        "\nSavings Goal: $" + savingsGoal +
                        "\nRemaining Balance: $" + remainingBalance,
                "Monthly Report", JOptionPane.INFORMATION_MESSAGE);
    }
}
