package Project;
import javax.swing.JOptionPane;

public class IncomeTracking {

    public static void Income() {

    //ask the user if they want to do the income.
    //System.out.println("Would you like to do the income? (Enter y for yes, and n for no):");


        String response = JOptionPane.showInputDialog("Would you like to do the income? (Enter y for yes, and n for no):");

        if (response != null && !response.isEmpty()) {


            if (response.equalsIgnoreCase("y")) {


                // System.out.println("Please enter your salary.");

                double salary = Double.parseDouble(JOptionPane.showInputDialog("Please enter your salary."));


                // user.nextDouble();


                System.out.println("Your taxes is: " + salary);

                //System.out.println("Please enter your : " + income);



            }

        }
   
   
        else {

        JOptionPane.showMessageDialog(null, "Hello, you didn't enter a response.");





      }

    }





}



