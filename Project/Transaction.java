package Project;

//Jacob

import java.util.ArrayList;
//import java.io.IOException;
import javax.swing.JOptionPane;

public class Transaction {

    public double sum;
    public ArrayList<Double> transact;
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
                    input = (JOptionPane.showInputDialog("Enter desired amount to subtract (in dollars).\nTo exit, leave blank or select 'Exit'."));

                    // If input is empty (i.e., user wants to exit), break out of the loop
                    if (input == null || input.isEmpty()) {
                        int option = JOptionPane.showOptionDialog(null, "Do you want to continue the transaction?", "Transaction Options", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[]{"Continue", "Exit"}, "Continue");
                        if (option == 1) {
                            showTransactionHistory();
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
    public double getTotal(){
        for(double total : transact) {
            sum += total;
        }
        return sum;
    }
}


