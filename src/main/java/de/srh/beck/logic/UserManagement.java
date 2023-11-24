package de.srh.beck.logic;

import de.srh.beck.dao.User;
import de.srh.beck.database.IDatabaseConnection;
import de.srh.beck.database.MySQLConnection;

public class UserManagement {

    private IDatabaseConnection connection;

    public UserManagement() {
        this.connection = new MySQLConnection();
    }

    public boolean saveUser(User user) {
        if (user == null) {
            return false;
        }

        return this.connection.addUser(user);
    }

    public User authenticateUser(String email, String password) {

        if (email != null && !email.isBlank()
                && password != null && !password.isBlank()) {

            User user = this.connection.getUserByEmail(email);
            if (user != null) {
                String md5 = this.connection.getMD5(password);
                if (md5.equals(user.getPassword())) {
                    return user;
                }
            }
        }

        return null;
    }


    /**
     * The function takes email and password from frontend and searches for the same data in the user table.
     * If user found return user object, if not returns null.
     *
     * @param email String, user e-mail-address. Not empty or null values required.
     * @param password String, plain text user password. Not empty or null values required.
     * @return User object, if user found. Null if not found.
     */
    public User authenticateUser2(String email, String password) {
        //TODO: Dokumentation
        //TODO: Validate DATA (Ressourcen schonen, Sicherheitsrisiko)
        //TODO: Datenbankverbindung
        //TODO: Vergleichen Input mit den Werten aus der Datenbank Tabelle tbl_user
        //TODO: SQL Befehl: SELECT * FROM tbl_user WHERE email LIKE email AND hash_password LIKE MD5(password);
        //TODO: Mapping: die Werte aus der Datenbank in ein User Objekt übertragen
        //TODO: Architekturanpassungen
        //TODO: Verbesserungen
        User user = null;
        if (email != null && password != null) {
            //datenbankverbindung
            user = this.connection.findUserByEmailAndPassword(email, password);
        }

        return user;
    }
}
