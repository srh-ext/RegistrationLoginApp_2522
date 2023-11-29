package de.srh.beck;

import com.mysql.cj.callback.MysqlCallback;
import de.srh.beck.database.MySQLConnection;
import de.srh.beck.ui.terminal.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private ArrayList<IMenu> menus = null;

    private ArrayList<IMenu> userMenu = null;

    public Main() {
        this.menus = new ArrayList<IMenu>();
        this.menus.add(new Registration());
        this.menus.add(new Login());
        this.menus.add(new Exit());

        this.userMenu = new ArrayList<IMenu>();
        this.userMenu.add(new Logout());
        this.userMenu.add(new Exit());
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            //Show menu list
            for (int i = 0; i < this.menus.size(); i++) {
                IMenu menu = this.menus.get(i);

                if (!menu.isLogout()) {
                    System.out.println(i + 1 + ": " + menu.getName());
                }
            }
            //Angaben auslesen
            System.out.print("Choose menu > ");
            String selectedMenuText = scanner.nextLine();
            try {
                Integer selectedMenu = Integer.valueOf(selectedMenuText) - 1;
                //TODO: refactor validation
                if (selectedMenu < this.menus.size()) {
                    //Show menu dialog
                    IMenu menu = this.menus.get(selectedMenu);
                    menu.showDialog();

                    if (menu.isExit()) {
                        break;
                    }
                } else {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException ex) {
                System.out.println("INFO: Please select valid menu number!");
            }
        }

        //TODO: Interactive menu
        //TODO: Logout only if user authenticated/authorized
        //TODO: login only if user not authenticated
        /*
        TODO: Menu
         1. Registration
         2. Login
         3. Exit

         TODO: after authentication
             1. Logout
             2. Exit

             (R)egistration
             (L)ogin
             (E)xit
         */
        /*
         TODO: Exception if the input incorrect.
                The application should provide menu selection one more time.
         TODO:
              Registration --> main menu
              Login -> Logout
              Logout -> main menu
              Exit --> stop application
        */
        /*
        TODO:
            Registration --> show Registration mask --> save user --> main menu
            Login --> show login mask --> logout menu
            Logout --> show logout info --> main menu
            Exit --> application stop

         */
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.showMenu();
    }
}