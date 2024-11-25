package Project;

//David

import java.io.*;
import javax.swing.JOptionPane;

public class MonthlyReport {

    // Write total expenses to CSV
    public void writeTotalExpenses(double totalExpenses) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/Project/MonthlyReport.csv"))) {
            writer.newLine();
            writer.write("Total Calculated Expenses: $" + totalExpenses);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "An error occurred while writing to the file: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    // Calcs while asking Transaction
    public double calculateTotalExpenses() {
        double totalExpenses = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader("MonthlyReport.csv"))) {
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
        writeTotalExpenses(totalExpenses);
        return totalExpenses;
    }
    // Calcs total
    public void showExpenses() {
        StringBuilder fileContent = new StringBuilder();
        double totalExpenses = calculateTotalExpenses();

        try (BufferedReader reader = new BufferedReader(new FileReader("MonthlyReport.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                fileContent.append(line).append("\n");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "An error occurred while reading the file: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Display the file
        JOptionPane.showMessageDialog(null,
                "File Content:\n" + fileContent.toString() + "\n\nExpenses this Month: $" + totalExpenses,
                "Monthly Report", JOptionPane.INFORMATION_MESSAGE);
    }
}
