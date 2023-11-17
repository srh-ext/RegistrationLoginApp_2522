package de.srh.beck;

import com.mysql.cj.callback.MysqlCallback;
import de.srh.beck.database.MySQLConnection;
import de.srh.beck.ui.terminal.*;

import java.util.ArrayList;
import java.util.Arrays;

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
        System.out.println(Arrays.toString(new MySQLConnection().getAllUser().toArray()));
    }
    public static void main(String[] args) {
        Main main = new Main();
        main.showMenu();
    }
}