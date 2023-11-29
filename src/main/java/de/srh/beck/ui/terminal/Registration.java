package de.srh.beck.ui.terminal;

import de.srh.beck.dao.User;

import java.sql.Date;
import java.util.Scanner;

public class Registration extends Menu {

    private static final String MENU_NAME = "Registration";

    public Registration() {
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

        System.out.println("Please feel the registration form.");
        User user = new User();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter gender [MR/MRS]> ");
        String gender = scanner.nextLine();
        user.setGender(User.Gender.valueOf(gender));

        System.out.print("Please enter first name > ");
        String firstname = scanner.nextLine();
        user.setFirstname(firstname);

        System.out.print("Please enter last name > ");
        String lastname = scanner.nextLine();
        user.setLastname(lastname);

        System.out.print("Please enter your birthdate [YYYY-MM-DD]> ");
        Date birthdate = Date.valueOf(scanner.nextLine());
        user.setBirthdate(birthdate);

        System.out.print("Please enter e-mail address > ");
        String email = scanner.nextLine();
        user.setEmail(email);

        System.out.print("Please enter password > ");
        String password = scanner.nextLine();
        user.setPassword(password);

        System.out.println("=================================");
        System.out.println("Your input: ");
        System.out.println(user);
        System.out.println("=================================");

        //save user into database
        boolean wasSaved = this.getUserManagement().saveUser(user);
        if (wasSaved) {
            System.out.println("INFO: You was successfully registered."
                    + "\nYou can proceed with login.");
        } else {
            System.out.println("INFO: user cannot be registered! Please try later.");
        }
    }
}
