package de.srh.beck.ui.terminal;

public class Logout extends Menu {

    private static final String MENU_NAME = "Logout";

    public Logout() {
        this.setName(MENU_NAME);
    }

    @Override
    public void showDialog() {
        super.showDialog();
        System.out.println(MENU_NAME);
    }

    @Override
    public boolean isLogout() {
        return true;
    }
}
