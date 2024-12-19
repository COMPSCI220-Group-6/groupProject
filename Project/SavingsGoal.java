package Project;

import javax.swing.*;
import java.io.IOException;

public class SavingsGoal extends Transaction{

    public static int usrSavings;

    public static int savingsGoal(){
        String message = JOptionPane.showInputDialog(null, "Input Total savings goal", "Savings Goal", JOptionPane.PLAIN_MESSAGE);
        usrSavings = Integer.parseInt(message);
        return usrSavings;
    }
    public static int amtGoal(){
        return usrSavings;
    }
    public static double actualTotal() throws IOException {
        return getTotal() + amtGoal();
    }
}
