package main.server.persistence.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface IDBConnection {
    Connection getConnection() throws DataConnectionException;
    void closeConnection();
    PreparedStatement createPreparedStatement(String preparedSql) throws DataConnectionException;
}
