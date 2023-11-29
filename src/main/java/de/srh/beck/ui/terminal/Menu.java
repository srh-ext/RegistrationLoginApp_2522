package de.srh.beck.ui.terminal;

import de.srh.beck.dao.User;
import de.srh.beck.logic.UserManagement;

public abstract class Menu implements IMenu {

    private String name = "Menu";

    private UserManagement userManagement = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void showDialog() {
    }

    @Override
    public boolean isExit() {
        return false;
    }

    @Override
    public boolean isLogout() {
        return false;
    }

    @Override
    public void setUserManagement(UserManagement um) {
        this.userManagement = um;
    }

    @Override
    public UserManagement getUserManagement() {
        return this.userManagement;
    }
}
