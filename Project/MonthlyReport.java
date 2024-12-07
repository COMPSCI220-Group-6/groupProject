package Project;

import java.io.*;
import javax.swing.JOptionPane;

public class MonthlyReport extends Transaction{

    private double salary;
    private double taxes;
    private double savingsGoal;
    public double totalExpenses = getTotal();

    // Write total expenses to CSV
    public void writeTotalExpenses(double totalExpenses) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Project/MonthlyReport.csv", true))) {
            writer.newLine();
            writer.write("Total Calculated Expenses: $" + totalExpenses);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "An error occurred while writing to the file: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Calculate total expenses
    public double calculateTotalExpenses() {
        totalExpenses = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader("Project/MonthlyReport.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Total Transactions: $")) {
                    String amountString = line.substring("Total Transactions: $".length());
                    totalExpenses += Double.parseDouble(amountString);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "An error occurred while reading the file: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        return totalExpenses;
    }

    // Retrieve salary and calculate taxes
    public void calculateSalaryAndTaxes() {
        IncomeTracking incomeTracking = new IncomeTracking();
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
        SavingsGoal savingsGoalCalculator = new SavingsGoal();
        savingsGoal = savingsGoalCalculator.savingsGoal();
        JOptionPane.showMessageDialog(null, "Your savings goal is: $" + savingsGoal);
    }

    // Show expenses along with salary, taxes, and savings goal
    public void showExpenses() {
        StringBuilder fileContent = new StringBuilder();
        totalExpenses = calculateTotalExpenses();
        calculateSalaryAndTaxes();
        calculateSavingsGoal();

        double remainingBalance = salary - taxes - totalExpenses - savingsGoal;

        try (BufferedReader reader = new BufferedReader(new FileReader("Project/MonthlyReport.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                fileContent.append(line).append("\n");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "An error occurred on the file: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Display the file and calculated data
        JOptionPane.showMessageDialog(null,
                "File Content:\n" + fileContent.toString() +
                        "\n\nExpenses this Month: $" + totalExpenses +
                        "\nSalary: $" + salary +
                        "\nTaxes: $" + taxes +
                        "\nSavings Goal: $" + savingsGoal +
                        "\nRemaining Balance: $" + remainingBalance,
                "Monthly Report", JOptionPane.INFORMATION_MESSAGE);
    }
}
