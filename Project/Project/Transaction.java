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
        String input = JOptionPane.showInputDialog("Subtract desired amount to transact(in dollars).\nTo exit/continue leave blank.");
        while (true){
            try {
                while (!input.isEmpty()) {
                    double amount = Double.parseDouble(input);
                    transact.add(amount);
                    input = (JOptionPane.showInputDialog("Subtract desired amount to transact(in dollars).\nTo exit/continue leave blank."));
                    //input = (JOptionPane.showOptionDialog(null, "Subtract desired amount to transact(in dollars).","" ,JOptionPane.YES_NO_OPTION,));
                }
                Transaction = true;
                break;
            }
            catch (NumberFormatException e ){
                System.out.println("exit Transaction class");
                input = (JOptionPane.showInputDialog("Not desired input please put in number.\nPlease try again."));
            }

        }
    }
    public double getTotal(){
        for(double total : transact) {
            sum += total;
        }
        return sum;
    }



}
