package Project;

//Jacob

import java.util.ArrayList;
//import java.io.IOException;
import javax.swing.JOptionPane;

public class Transaction {

    public double sum;
    public ArrayList<Double> transact;

    public boolean Transact() {
        transact = new ArrayList<Double>();
        String input = JOptionPane.showInputDialog("Enter desired amount to subtract (in dollars).\nTo exit, select 'Exit'.");

        while (true) {
            try {
                if (input == null || input.isEmpty()) {
                    int option = JOptionPane.showOptionDialog(null, "Do you want to continue the transaction?", "Transaction Options", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[]{"Continue", "Exit"}, "Continue");
                    if (option == 1) {
                        showTransactionHistory();
                        return true;
                    } else {
                        // User wants to continue entering amounts
                        input = JOptionPane.showInputDialog("Enter desired amount to subtract (in dollars).\nTo exit, or select 'Exit'.");
                        if (input == null || input.isEmpty()) {
                            break;
                        }
                    }
                } else {
                    double amount = Double.parseDouble(input); // Parse the input to a double
                    transact.add(amount);
                    input = JOptionPane.showInputDialog("Enter desired amount to subtract (in dollars).\nTo exit, or select 'Exit'.");
                }
            } catch (NumberFormatException e) {
                // Handle invalid input and prompt the user again
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number for the transaction.");
                input = JOptionPane.showInputDialog("Enter desired amount to subtract (in dollars).\nTo exit, or select 'Exit'.");
            }
        }
        return false;  // Optionally return false to indicate that the transactions were not completed if no valid data was entered
    }
    public void showTransactionHistory() {
        if (!transact.isEmpty()) {
            StringBuilder history = new StringBuilder("Transaction History:\n");
            for (Double amount : transact) {
                history.append("$").append(amount).append("\n");
            }
            JOptionPane.showMessageDialog(null, history.toString());
        } else {
            JOptionPane.showMessageDialog(null, "No transactions made.");
        }
    }
    public double getTotal(){
        for(double total : transact) {
            sum += total;
        }
        return sum;
    }
}


