package Project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

public class UserAuthentication {

    public boolean login = false;

    // file used here
    public void login() throws IOException {
        String filePath = "Project/UserFile.csv";
        String usernameInput;
        String passwordInput;

        while (!login) {
            usernameInput = JOptionPane.showInputDialog(null, "Username:", "User Login", JOptionPane.PLAIN_MESSAGE);
            if (usernameInput == null) {
                return;
            }
            passwordInput = JOptionPane.showInputDialog(null, "Password:", "User Login", JOptionPane.PLAIN_MESSAGE);
            if (passwordInput == null) {
                return;
            }

            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                String line;
                boolean userFound = false;

                while ((line = br.readLine()) != null) {
                    String[] fileData = line.split(",");
                    String username = fileData[0].trim();
                    String password = fileData[1].trim();

                    // Check credentials
                    if (usernameInput.equalsIgnoreCase(username) && passwordInput.equals(password)) {
                        login = true;
                        userFound = true;
                        //JOptionPane.showMessageDialog(null, "Login successful!", "User Login", JOptionPane.INFORMATION_MESSAGE);
                        break; // Exit
                    }
                }
                if (!userFound) {
                    JOptionPane.showMessageDialog(null, "Invalid username or password. Please try again.", "User Login", JOptionPane.ERROR_MESSAGE);
                }

            } catch (IOException e) {
                System.out.println("Error reading file. UH OH");
                e.printStackTrace();
            }
        }
    }
}
