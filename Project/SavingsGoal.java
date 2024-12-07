package Project;

import javax.swing.*;

public class SavingsGoal extends Transaction{
    public int savingsGoal(){
        String message = JOptionPane.showInputDialog(null, "Input total savings goal", "Savings Goal", JOptionPane.PLAIN_MESSAGE);
        return Integer.parseInt(message);
    }
    public double actualTotal(){
        return getTotal() + savingsGoal();
    }
}
