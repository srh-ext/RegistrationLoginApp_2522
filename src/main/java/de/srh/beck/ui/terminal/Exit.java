package de.srh.beck.ui.terminal;

public class Exit extends Menu {

    private static final String MENU_NAME = "Exit";

    public Exit() {
        this.setName(MENU_NAME);
    }

    @Override
    public void showDialog() {
        super.showDialog();
        System.out.println(MENU_NAME);
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
