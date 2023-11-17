package de.srh.beck.database;

import de.srh.beck.dao.User;

import java.sql.*;
import java.util.ArrayList;

public class MySQLConnection implements IDatabaseConnection {

    private final String host = "127.0.0.1";
    private final String username = "root";
    private final String password = "root";
    private final int port = 8889;
    private final String dbname = "reg_login_app_2522";
    private Connection connection = null;

    public MySQLConnection() {
    }

    @Override
    public Connection getConnection() {
        if (this.connection == null) {

            String url = "jdbc:mysql://" + host + ":" + port + "/" + dbname;
            try {
                connection = DriverManager.getConnection(url, username, password);
            } catch (SQLException ex) {
                System.out.println("ERROR: cannot connect to the database. " + ex.getMessage());
            }
        }

        return connection;
    }

    public ArrayList<User> getAllUser() {
        ArrayList<User> users = new ArrayList<>();
        try {
            Statement statement = this.getConnection().createStatement();
            ResultSet set = statement.executeQuery("SELECT * FROM tbl_user;");
            if (set != null) {
                while(set.next()) {
                    User user = new User();
                    user.setUserId(set.getInt("user_id"));
                    user.setFirstname(set.getString("first_name"));
                    user.setLastname(set.getString("last_name"));
                    user.setGender(User.Gender.valueOf(set.getString("gender")));
                    user.setEmail(set.getString("email"));
                    user.setPassword(set.getString("hash_password"));
                    user.setBirthdate(set.getDate("birthdate"));

                    users.add(user);
                }
            }
            this.getConnection().close();

        } catch (SQLException ex) {
            System.out.println("ERROR: cannot execute statement. " + ex.getMessage());
        }

        return users;
    }
}
