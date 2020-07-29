package main.server.persistence.receptionist;

import main.server.persistence.database.DataConnectionException;
import main.server.persistence.database.IDBConnection;
import main.shared.Receptionist;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReceptionistDAO implements IReceptionistDAO {
    private final IDBConnection databaseConnection;

    public ReceptionistDAO(IDBConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    @Override
    public Receptionist getReceptionist(int Id) {
        Receptionist receptionist = null;
        try{
            String sql = "SELECT * FROM " + databaseConnection.getReceptionistTableName()+ " WHERE ID = " + Id + ";";
            PreparedStatement preparedStatement = databaseConnection.createPreparedStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while ( resultSet.next()) {
                int id = resultSet.getInt("ID");
                String userName = resultSet.getString("userName");
                String passWord = resultSet.getString("passWord");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String email = resultSet.getString("email");
                String phoneNumber = resultSet.getString("phoneNumber");
                String workRole = resultSet.getString("workRole");
                receptionist = new Receptionist(id, userName,  passWord,  firstName,  lastName,  email,  phoneNumber,  workRole);
            }
        } catch (DataConnectionException | SQLException e) {
            e.printStackTrace();
        } finally {
            databaseConnection.closeConnection();
        }
        return receptionist;
    }
}
