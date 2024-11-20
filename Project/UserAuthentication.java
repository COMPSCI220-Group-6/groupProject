package Project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

public class UserAuthentication{

    public boolean login = false;
    // file used here
    public void login() throws IOException{
        String filePath = "Project/UserFile.csv";

        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String Line;
            String usernameInput = JOptionPane.showInputDialog(null,"Username:", "User Login", JOptionPane.PLAIN_MESSAGE);
            String passwordInput = JOptionPane.showInputDialog(null,"Password:", "User Login", JOptionPane.PLAIN_MESSAGE);

            while ((Line = br.readLine()) != null) {

                //get user info stored
                String[] file = Line.split(",");
                String username = file[0].trim();
                String password = file[1].trim();

                //check against input
                while (file.length >= 2 && !login){
                    if(!usernameInput.equalsIgnoreCase(username)) {
                        usernameInput = JOptionPane.showInputDialog(null,"Retry user login: ", "User Login", JOptionPane.PLAIN_MESSAGE);
                        passwordInput = JOptionPane.showInputDialog(null,"Retry user password: ", "User Login", JOptionPane.PLAIN_MESSAGE);
                    } else if (!passwordInput.equals(password)) {
                        passwordInput = JOptionPane.showInputDialog(null,"Retry user password: ", "User Login", JOptionPane.PLAIN_MESSAGE);
                    } else if (usernameInput.equalsIgnoreCase(username) && passwordInput.equals(password)){
                        login = true;
                        break;
                    } else{
                        login = false;
                    }
                }
            }
        }
        catch(IOException e){
            System.out.println("No work. UH OH");
            e.printStackTrace();
        }
    }
}
