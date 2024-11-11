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
            String usernameInput = JOptionPane.showInputDialog("User login:");
            String passwordInput = JOptionPane.showInputDialog("User password:");

            while ((Line = br.readLine()) != null) {
                
                String[] file = Line.split(",");
                String username = file[0].trim();
                String password = file[1].trim();
                if (file.length >= 2){
                    if (usernameInput.equalsIgnoreCase(username) && passwordInput.equals(password)){
                        login = true;
                        break;
                    } else{
                        login = false;
                    }

                    if(!login){
                        usernameInput = JOptionPane.showInputDialog("Retry user login: ");
                        passwordInput = JOptionPane.showInputDialog("Retry user password: ");
                        continue;
                    }
                }
            }
        } catch(IOException e){
            System.out.println("No work. UH OH");
            e.printStackTrace();
        }
    }
}
