package de.srh.beck.ui.terminal;

import de.srh.beck.logic.UserManagement;

public interface IMenu {

    String getName();

    boolean isExit();

    boolean isLogout();

    void showDialog();

    void setUserManagement(UserManagement um);

    UserManagement getUserManagement();
}
