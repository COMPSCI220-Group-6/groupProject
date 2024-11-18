package Project;

import java.util.ArrayList;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Transaction {

    public double sum;
    public ArrayList<Double> transact;

    public void Transact(){
        transact = new ArrayList<Double>();
        String input = JOptionPane.showInputDialog("Subtract desired amount to transact(in dollars)\nTo exit/continue leave blank");
        try {
            while (!input.isEmpty()) {
                double amount = Double.parseDouble(input);
                transact.add(amount);
                input = (JOptionPane.showInputDialog("Subtract desired amount to transact(in dollars)\nTo exit/continue leave blank"));
            }
        }
        catch (NumberFormatException e ){
            System.out.println("exit Transaction class");
        }
    }
    public double getTotal(){
        for(double total : transact) {
            sum += total;
        }
        return sum;
    }



}
