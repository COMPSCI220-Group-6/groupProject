package Project;

import java.io.*;
import javax.swing.JOptionPane;


public class MonthlyReport {

    private double salary;
    private double taxes;
    private double savingsGoal;
    private double totalExpenses;
    private final String TEMP_FILE = "Project/TemporaryReport.csv";

    // Show expenses along with salary, taxes, and savings goal
    public void showExpenses() throws IOException {
        StringBuilder fileContent = new StringBuilder();

        double remainingBalance = IncomeTracking.getSalary() - IncomeTracking.getTaxes() - SavingsGoal.actualTotal();



        try (BufferedReader reader = new BufferedReader(new FileReader("Project/MonthlyReport.csv"));
            BufferedWriter writer = new BufferedWriter(new FileWriter(TEMP_FILE))){

            String line;
            while ((line = reader.readLine()) != null) {
                if(line.startsWith("Total Calculated Expenses: $")){
                    line = "Total Calculated Expenses: $" + Transaction.getTotal();
                } else if (line.startsWith("Total Salary: $")) {
                    line = "Total Salary: $" + IncomeTracking.getSalary();
                }else if (line.startsWith("Total Tax: $")){
                    line = "Total Tax: $" + IncomeTracking.getTaxes();
                }else if (line.startsWith("User Savings Goal: $")) {
                    line = "User Savings Goal: $" + SavingsGoal.amtGoal();
                }else if (line.startsWith("Estimated Savings Goal: $")){
                    line = "Estimated Savings Goal: $" + SavingsGoal.actualTotal();
                }else if (line.startsWith("Remaining Balance: $")){
                    line = "Remaining Balance: $" + remainingBalance;
                }
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "An error occurred on the file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        try (BufferedReader tempReader = new BufferedReader(new FileReader(TEMP_FILE))) {
            String line;
            while ((line = tempReader.readLine()) != null) {
                fileContent.append(line).append("\n");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "An error occurred while reading the temporary file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Display the file and calculated data
        JOptionPane.showMessageDialog(null, "\n" + fileContent.toString());
    }
}
