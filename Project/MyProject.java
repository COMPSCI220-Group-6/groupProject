package Project;

// Written by Jacob Toepfer, Joshua Young, David Pellas, John Torres

import javax.swing.*;
import java.io.IOException;


public class MyProject{

    public static void main(String[] args) throws IOException{
        UserAuthentication obj1 = new UserAuthentication();
        Transaction obj2 = new Transaction();
        SavingsGoal obj3 = new SavingsGoal();
        MonthlyReport obj4 = new MonthlyReport();
        obj1.login(); // call login for user (br, br)
        if (obj1.login) { //Start System here

            JOptionPane.showMessageDialog(null, "Please complete in order according to list. Thanks!");
            boolean loop = false;

            while(!loop) {
                String[] options = {"Exit", "Monthly report", "Savings Goal", "Transactions", "Income"};
                int choice = JOptionPane.showOptionDialog(null,
                        "Welcome to the Financial Planner! Please start from left to right:", "Main Menu",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                switch (choice) {
                    case 0:
                        // Exit the application
                        JOptionPane.showMessageDialog(null, "Thank you for using the Financial Planner! Goodbye.");
                        System.exit(0);
                        loop = true;
                    case 1:
                    	obj4.showExpenses();

                        break;
                    case 2:
                        // Savings Goal
                        JOptionPane.showMessageDialog(null, "Savings class is to gain information about saving goals.\nUser can input their goal to be used later.");
                        int savingsGoalAmount = obj3.savingsGoal();
                        JOptionPane.showMessageDialog(null, "Your savings goal is: $" + savingsGoalAmount);
                        break;
                    case 3:
                        // Transactions
                        JOptionPane.showMessageDialog(null, "Transact class is to calculate total expenses.\nUser can input each expense separately or all at once.");
                        obj2.Transact();
                        break;
                    case 4:
                        // Income
                        JOptionPane.showMessageDialog(null, "Income class is to calculate total money earned.\nUser can input their salary to the planner and calculate tax.");
                        IncomeTracking.Income();
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Invalid option selected.");
                }
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Login failed. Please try again.");
        }
    }
}
