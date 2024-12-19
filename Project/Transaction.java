package Project;

//Jacob

import java.io.IOException;
import java.util.ArrayList;
import java.io.FileWriter;
import javax.swing.JOptionPane;

public class Transaction {

    public static double sum;
    public static ArrayList<Double> transact;
    public boolean Transaction;

    public void Transact(){
        transact = new ArrayList<Double>();
        Transaction = false;
        String input = JOptionPane.showInputDialog("Enter desired amount to subtract (in dollars).\nTo exit, leave blank or select 'Exit'.");
        while (true){
            try {

                while (!input.isEmpty()) {
                    double amount = Double.parseDouble(input);  // Parse the amount
                    transact.add(amount);  // Add to the transaction list

                    // Ask for next transaction amount or exit option
                    input = (JOptionPane.showInputDialog("Enter desired amount to subtract (in dollars).\nTo exit, leave blank or select 'Cancel'."));

                    // If input is empty (i.e., user wants to exit), break out of the loop
                    if (input == null || input.isEmpty()) {
                        int option = JOptionPane.showOptionDialog(null, "Do you want to continue the transaction? To return to menu select 'Exit'.", "Transaction Options", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[]{"Continue", "Exit"}, "Continue");
                        if (option == 1) {
                            showTransactionHistory();
                            return;
                        } else{
                            input = (JOptionPane.showInputDialog("Enter desired amount to subtract (in dollars).\nTo exit, leave blank or select 'Exit'."));
                        }
                    }
                }
            }
            catch (NumberFormatException e ){
                System.out.println("exit Transaction class");
                input = (JOptionPane.showInputDialog("Not desired input please put in number.\nPlease try again."));
            }
        }

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


