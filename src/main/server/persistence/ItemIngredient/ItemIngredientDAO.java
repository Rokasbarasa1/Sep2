package main.server.persistence.ItemIngredient;

import main.server.persistence.database.DataConnectionException;
import main.server.persistence.database.IDBConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ItemIngredientDAO implements IItemIngredientDAO{
    private final IDBConnection databaseConnection;
    public ItemIngredientDAO(IDBConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    @Override
    public boolean insertIDIntoTable(int item_ID, int ingredient_ID) {

        try{
            String sql = "INSERT INTO ItemIngredient(item_ID,ingredient_ID) VALUES(?,?)";
            PreparedStatement preparedStatement = databaseConnection.createPreparedStatement(sql);
            preparedStatement.setInt(1,item_ID);
            preparedStatement.setInt(2, ingredient_ID);
            int i = preparedStatement.executeUpdate();
            if (i == 1){
                return true;
            }
        } catch (DataConnectionException | SQLException e) {
            e.printStackTrace();
        } finally {
            databaseConnection.closeConnection();
        }
        return false;
    }

    @Override
    public void deleteAllByItemID(int id) {
        try{
            String sql = "DELETE FROM ItemIngredient WHERE item_ID = " +id+ ";";
            PreparedStatement preparedStatement = databaseConnection.createPreparedStatement(sql);
            int i = preparedStatement.executeUpdate();
            if(i >0){
                System.out.println("ItemIngredients deleted");
            }
        } catch (DataConnectionException | SQLException e) {
            e.printStackTrace();
        } finally {
            databaseConnection.closeConnection();
        }
    }
}
