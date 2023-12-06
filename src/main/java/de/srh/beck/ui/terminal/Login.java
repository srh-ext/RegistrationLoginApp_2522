package de.srh.beck.ui.terminal;

import de.srh.beck.dao.User;
import de.srh.beck.validation.Validator;

import java.io.Console;
import java.util.Scanner;

public class Login extends Menu {

    private static final String MENU_NAME = "Login";

    public Login() {
        this.setName(MENU_NAME);
    }

    @Override
    public void showDialog() {
        super.showDialog();
        System.out.println("=================================");
        System.out.println(MENU_NAME);

        if (this.getUserManagement() == null) {
            System.out.println("ERROR: The service is not reachable. Please try later.");
            return;
        }

        System.out.println("Please login with your existing user credentials.");
        Scanner scanner = new Scanner(System.in);
        String email = null;
        String password = null;
        while(true) {
            //TODO: 3 times invalid password --> exit
            try {
                System.out.print("Please enter e-mail address > ");
                email = scanner.nextLine();
                Validator.isValid(email);

                System.out.print("Please enter password > ");
                password = scanner.nextLine();
                Validator.isValid(password);
            } catch (NullPointerException ex) {
                System.out.println(ex.getMessage());
                System.out.println("=================================");
                continue;
            }
            break;
        }

        //Console console = System.console();
        //char[] password = console.readPassword();

        User user = this.getUserManagement().authenticateUser2(email, password);

        System.out.println("=================================");
        if (user != null) {
            System.out.printf("Authentication successful");
            System.out.println("\nWelcome "
                                + user.getGender().toString()
                                + " "
                                + user.getLastname());
        } else {
            System.out.println("Authentication failed!" +
                    "\nUser Credentials might be not correct." +
                    " Try again!");
        }
        System.out.println("=================================");
    }
}
