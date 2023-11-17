package de.srh.beck.ui.terminal;

public class Registration extends Menu {

    private static final String MENU_NAME = "Registration";

    public Registration() {
        this.setName(MENU_NAME);
    }

    @Override
    public void showDialog() {
        super.showDialog();
        System.out.println(MENU_NAME);
    }
}
