package de.srh.beck;

import de.srh.beck.ui.terminal.*;

import java.util.ArrayList;

public class Main {

    private ArrayList<IMenu> menus = null;

    public Main() {
        this.menus = new ArrayList<IMenu>();
        this.menus.add(new Registration());
        this.menus.add(new Login());
        this.menus.add(new Logout());
        this.menus.add(new Exit());
    }

    public void showMenu() {
        for (IMenu menu : this.menus) {
            System.out.println(menu.getName());
        }
    }
    public static void main(String[] args) {
        Main main = new Main();
        main.showMenu();
    }
}