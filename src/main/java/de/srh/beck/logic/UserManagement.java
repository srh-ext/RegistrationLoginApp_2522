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
}
