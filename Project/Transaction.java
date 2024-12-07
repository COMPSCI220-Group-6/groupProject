package Project;

//Jacob

import java.util.ArrayList;
//import java.io.IOException;
import javax.swing.JOptionPane;

public class Transaction {

    public double sum;
    public ArrayList<Double> transact;
    public boolean Transaction;

    public boolean Transact(){
        transact = new ArrayList<Double>();
        Transaction = false;
        String input = JOptionPane.showInputDialog("Enter desired amount to subtract (in dollars).\nTo exit, select 'Exit'.");
        while (true){
            try {

                while (!input.isEmpty()) {

                    // Ask for next transaction amount or exit option
                    input = (JOptionPane.showInputDialog("Enter desired amount to subtract (in dollars).\nTo exit, select 'Exit'."));

                    if (input == null || input.isEmpty()) {
                        int option = JOptionPane.showOptionDialog(null, "Do you want to continue the transaction?", "Transaction Options", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[]{"Continue", "Exit"}, "Continue");
                        if (option == 1) {
                            showTransactionHistory();
                            return false;
                        } else {
                            input = (JOptionPane.showInputDialog("Enter desired amount to subtract (in dollars).\nTo exit, or select 'Exit'."));
                            if (input == null || input.isEmpty()) {
                                break;
                            }
                        }
                    }else {
                        double amount = Double.parseDouble(input);
                        transact.add(amount);
                        input = JOptionPane.showInputDialog("Enter desired amount to subtract (in dollars).\nTo exit, or select 'Exit'.");
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


