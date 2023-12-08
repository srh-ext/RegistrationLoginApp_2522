package de.srh.beck.ui.terminal;

import de.srh.beck.dao.User;
import de.srh.beck.validation.Validator;

import java.sql.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
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

        Scanner scanner = new Scanner(System.in);

        HashMap<String, String> map = new LinkedHashMap<>();
                //key               value
        map.put("gender [MR/MRS]", "enum");
        map.put("first name", null);
        map.put("last name", null);
        map.put("birthdate [YYYY-MM-DD]", "date");
        map.put("email address", null);
        map.put("password", null);

        for (String key: map.keySet()) {
            while(true) {
                try {
                    System.out.print("Please enter " + key + "> ");

                    String input = scanner.nextLine();

                    Validator.isValid(input);

                    map.replace(key, input);
                } catch (NullPointerException ex) {
                    System.out.println(ex.getMessage()
                            + "\nPlease enter " + key + " again.");
                    continue;
                }
                break;
            }
        }

        User user = new User();
        user.setGender(
                User.Gender.valueOf(
                        map.get("gender [MR/MRS]")));
        user.setFirstname(map.get("first name"));
        user.setLastname(map.get("last name"));
        user.setBirthdate(Date.valueOf(map.get("birthdate [YYYY-MM-DD]")));
        user.setEmail(map.get("email address"));
        user.setPassword(map.get("password"));

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
