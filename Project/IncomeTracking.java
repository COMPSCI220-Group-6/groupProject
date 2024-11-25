package Project;
import java.util.Scanner;

public class IncomeTracking {


    public static void Income() {


    Scanner user = new Scanner(System.in);



    //ask the user if they want to do the income.
    System.out.println("Would you like to do the income? (Enter y for yes, and n for no):");


    String response = user.nextLine();



    if (response.equalsIgnoreCase("y")){


            System.out.println("Please enter your salary.");

            double salary = user.nextDouble();



            System.out.println("Your taxes is: " + salary);

            //System.out.println("Please enter your : " + income);




        }
    else {





    }

    }





}



