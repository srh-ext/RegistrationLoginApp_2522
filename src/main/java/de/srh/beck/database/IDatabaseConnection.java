package de.srh.beck.database;

import de.srh.beck.dao.User;

import java.sql.Connection;

public interface IDatabaseConnection {

    Connection getConnection();

    String getMD5(String password);

    User getUserByEmail(String email);

    User getUserById(int userId);

    boolean addUser(User user);
}
