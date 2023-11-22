package de.srh.beck.database;

import de.srh.beck.dao.User;

import javax.swing.plaf.nimbus.State;
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

    public String getMD5(String password) {
        try {
            Statement statement = this.getConnection().createStatement();
            ResultSet set = statement.executeQuery(
                    "SELECT MD5('"+ password +"')");

            set.next();
            return set.getString(1);

        } catch (SQLException ex) {
            System.out.println("ERROR: cannot execute statement. " + ex.getMessage());
        }

        return null;
    }

    public User getUserById(int userId) {
        return null;
    }

    public User getUserByEmail(String email) {
        User user = null;
        String sql = "SELECT * FROM tbl_user WHERE email LIKE ? LIMIT 1";
        try {
            PreparedStatement ps = this.getConnection().prepareStatement(sql);
            ps.setString(1, email);

            ResultSet set = ps.executeQuery();
            if(set.next()) {
                user = new User();
                user.setUserId(set.getInt("user_id"));
                user.setEmail(set.getString("email"));
                user.setBirthdate(set.getDate("birthdate"));
                user.setFirstname(set.getString("first_name"));
                user.setLastname(set.getString("last_name"));
                user.setPassword(set.getString("hash_password"));
            }

        } catch (SQLException ex) {
            System.out.println("ERROR: cannot execute statement. " + ex.getMessage());
        }
        return user;
    }

    public boolean addUser(User user) {
        try {
            /*
            Statement statement = this.getConnection().createStatement();
            statement.executeUpdate("INSERT INTO tbl_user"
                    + "(gender, first_name, last_name, email, hash_password, birthdate)"
                    + "VALUES"
                    + "('"
                    + user.getGender() + "','"
                    + user.getFirstname() + "','"
                    + user.getLastname() + "','"
                    + user.getEmail() + "',"
                    + "MD5('" + user.getPassword() + "'),'"
                    + user.getBirthdate()
                    + "')");
            */
            String sql = "INSERT INTO tbl_user"
                    + "(gender, first_name, last_name, email, hash_password, birthdate)"
                    + "VALUES(?, ?, ?, ?, MD5(?), ?)";

            PreparedStatement ps =this.getConnection().prepareStatement(sql);
            ps.setString(1, user.getGender().toString());
            ps.setString(2, user.getFirstname());
            ps.setString(3, user.getLastname());
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getPassword());
            ps.setDate(6, user.getBirthdate());

            int result = ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("ERROR: cannot execute statement. " + ex.getMessage());
            return false;
        }

        return true;
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
