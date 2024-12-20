package Project;

//Jacob

import java.io.IOException;
import java.util.ArrayList;
import java.io.FileWriter;
import javax.swing.JOptionPane;
import java.util.List;

public class Transaction {

    public static double sum;
    public static ArrayList<Double> transact;
    //public boolean Transaction = false;

    public void Transact(){
        List<Double> transact = new ArrayList<>();

        // List of categories
        List<String> expenseCategories = List.of("rent (monthly)", "insurance (monthly)", "utilities (monthly)", "groceries (monthly)");

        int categoryIndex = 0;
        String input = JOptionPane.showInputDialog("Enter the cost of " + expenseCategories.get(categoryIndex) + ".\nTo exit, leave blank or select 'Cancel'.");

        while (true) {
            try {
                while (input != null && !input.isEmpty()) {
                    double amount = Double.parseDouble(input);
                    transact.add(amount);

                    categoryIndex++;
                    if (categoryIndex < expenseCategories.size()) {
                        input = JOptionPane.showInputDialog("Enter the cost of " + expenseCategories.get(categoryIndex) + ".\nTo exit, leave blank or select 'Cancel'.");
                    } else {
                        int option = JOptionPane.showOptionDialog(null, "Do you want to add more expenses? To return to the menu, select 'Exit'.", "Transaction Options", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[]{"Continue", "Exit"}, "Continue");

                        if (option == 1) {
                            showTransactionHistory(transact);
                            return;
                        } else {
                            categoryIndex = 0;
                            input = JOptionPane.showInputDialog("Enter the cost of " + expenseCategories.get(categoryIndex) + ".\nTo exit, leave blank or select 'Cancel'.");
                        }
                    }
                }
            } catch (NumberFormatException e) {
                input = JOptionPane.showInputDialog("Invalid input. Please enter a number.\nEnter the cost of " + expenseCategories.get(categoryIndex) + ".\nTo exit, leave blank or select 'Cancel'.");
            }
            if (input == null || input.isEmpty()) {
                int option = JOptionPane.showOptionDialog(null, "Do you want to continue or exit to the menu?", "Transaction Options", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[]{"Continue", "Exit"}, "Continue");

                if (option == 1) {
                    showTransactionHistory(transact);
                    categoryIndex = 0;
                    return;
                } else {
                    categoryIndex = 0;
                    input = JOptionPane.showInputDialog("Enter the cost of " + expenseCategories.get(categoryIndex) + ".\nTo exit, leave blank or select 'Cancel'.");
                }
            }
        }
    }

    public void showTransactionHistory(List<Double> transact) {
        StringBuilder history = new StringBuilder("Transaction History:\n");
        for (int i = 0; i < transact.size(); i++) {
            history.append("Expense ").append(i + 1).append(": $").append(transact.get(i)).append("\n");
        }
        JOptionPane.showMessageDialog(null, history.toString(), "Transaction History", JOptionPane.INFORMATION_MESSAGE);
    }

    public static double getTotal() {
    String filePath = "Project/MonthlyReport.csv";
    for(double total : transact) {
        sum += total;
    }
    try (FileWriter writer = new FileWriter(filePath, true)) {
        writer.write(String.valueOf(sum));
    } catch (IOException e) {
        System.err.println("An error occurred: " + e.getMessage());
    }
    return Math.ceil(sum * 100) / 100;
    }
}


