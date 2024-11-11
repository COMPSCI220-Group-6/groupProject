package Project;
// David was here


//Joshua was here


import java.io.IOException;


public class MyProject{

    public static void main(String[] args) throws IOException{
        UserAuthentication obj1 = new UserAuthentication();
        Transaction obj2 = new Transaction();
        //IncomeTracking obj3 = new IncomeTracking();
        //SavingsGoal obj4 = new SavingsGoal();

        obj1.login(); // call login for user (bread, bread)
        if (obj1.login) {
            System.out.println("European union");
            //Start System here
            obj2.Transact(); // call transact class
            System.out.println(obj2.getTotal());
        }


    
    }
    
}
