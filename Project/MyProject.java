package Project;

// Written by Jacob Toepfer, Joshua Young, David Pellas, John Torres

import javax.swing.*;
import java.io.IOException;


public class MyProject{

    public static void main(String[] args) throws IOException{
        UserAuthentication obj1 = new UserAuthentication();
        Transaction obj2 = new Transaction();
        //IncomeTracking obj3 = new IncomeTracking();
        //SavingsGoal obj4 = new SavingsGoal();

        obj1.login(); // call login for user (br, br)
        if (obj1.login) {
            System.out.println("European union");
            //Start System here
            JOptionPane.showMessageDialog(null, "Transact class is to calculate total expenses.\nUser can input each expense separately or all at once.");
            obj2.Transact(); // call transact class
            System.out.println(obj2.getTotal());
        }
        if (obj2.Transaction){
            System.out.println("Masterbuilding");
        }


    
    }
    
}
