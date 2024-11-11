package Project;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Transaction {

    public ArrayList<Double> transact;

    public void Transact(){
        transact = new ArrayList<Double>();
        double amount = Double.parseDouble(JOptionPane.showInputDialog("Subtract desired amount to transact(in dollars)"));
        while(amount < 0.0) {
            transact.add(amount);
            amount = Double.parseDouble(JOptionPane.showInputDialog("Subtract desired amount to transact(in dollars)"));
        }
    }



}
