package main.server.persistence.login;

import main.server.persistence.database.DataConnectionException;
import main.server.persistence.database.IDBConnection;
import main.shared.Receptionist;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO implements ILoginDAO {

    private final IDBConnection databaseConnection;

    public LoginDAO(IDBConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    @Override
    public String validateLogin(Receptionist receptionist) {
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        String conclusion= "Database not responding";
        try {
            String sql = "SELECT receptionist_ID, userName, passWord FROM " + databaseConnection.getSchemaName() + "." + databaseConnection.getReceptionistTableName() +
                    " WHERE username LIKE '" + receptionist.getUsername() + "'  AND password LIKE '" + receptionist.getPassword() + "'";
            preparedStatement = databaseConnection.createPreparedStatement(sql);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("Users_ID");
                conclusion = "Login successful;"+id;
            }
            else{
                conclusion = "Username or password is incorrect";
            }
        } catch (DataConnectionException | SQLException e) {
            e.printStackTrace();
        } finally {
            databaseConnection.closeConnection();
        }
        return conclusion;
    }
}
