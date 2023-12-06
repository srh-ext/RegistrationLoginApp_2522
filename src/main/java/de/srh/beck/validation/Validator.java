package de.srh.beck.validation;

public class Validator {

    public static boolean isValid(String text) {
        if(text != null && !text.isBlank() && text.length() > 2) {
            return true;
        } else {
            throw new NullPointerException("WARN: the input is invalid!");
        }
    }

    public static void countInvalidLogins() {

    }
}
