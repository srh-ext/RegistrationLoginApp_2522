package de.srh.beck.ui.terminal;

public class Login extends Menu {

    private static final String MENU_NAME = "Login";

    public Login() {
        this.setName(MENU_NAME);
    }

    @Override
    public void showDialog() {
        super.showDialog();
        System.out.println(MENU_NAME);
    }
}
