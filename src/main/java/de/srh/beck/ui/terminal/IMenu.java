package de.srh.beck.ui.terminal;

public interface IMenu {

    String getName();

    boolean isExit();

    boolean isLogout();

    void showDialog();
}
