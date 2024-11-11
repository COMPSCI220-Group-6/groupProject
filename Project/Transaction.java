package Project;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Transaction extends MyProject{

    private double amount;

    public Transaction(double amount){
        ArrayList<Integer> transact = new ArrayList<>();
        amount = Double.parseDouble(JOptionPane.showInputDialog("Subtract desired amount (in dollars)"));

    }
}
