package de.srh.beck.validation;

import de.srh.beck.dao.User;

import java.sql.Date;

public class Validator {

    public enum Type {
        gender,
        email,
        password,
        date,
        text
    }

    public static boolean isValid(String text) {
        if(text != null && !text.isBlank() && text.length() > 1) {
            return true;
        } else {
            throw new NullPointerException("WARN: the input is invalid!");
        }
    }

    public static boolean isValid(String text, Type validator) {
        isValid(text);
        try {
            switch (validator) {
                case date:
                    validateDate(text);
                    break;
                case password:
                    validatePassword(text);
                    break;
                case gender:
                    validateGender(text);
                    break;
                case email:
                    EmailValidator.isValid(text);
                    break;
                default:
                    break;

            }
        } catch (Exception ex) {
            throw new NullPointerException("WARN: the input is invalid!"
                    + "\n" + ex.getMessage());
        }

        return true;
    }

    private static void validatePassword(String text) throws Exception {
        if (text.length() < 6) {
            throw new Exception("Password should have at least 6 chars.");
        }
    }

    private static void validateDate(String text) throws Exception {
        try {
            Date.valueOf(text);
        } catch (Exception ex) {
            throw new Exception("Invalid date. Please use YYYY-MM-DD format.");
        }
    }

    private static void validateGender(String text) throws Exception {
        try {
            User.Gender.valueOf(text);
        } catch (IllegalArgumentException ex) {
            throw new Exception("Invalid gender naming. Please select between MR or MRS.");
        }
    }

    public static void countInvalidLogins() {

    }
}
