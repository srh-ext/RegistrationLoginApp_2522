package de.srh.beck.database;

import java.sql.Connection;

public interface IDatabaseConnection {

    Connection getConnection();
}
