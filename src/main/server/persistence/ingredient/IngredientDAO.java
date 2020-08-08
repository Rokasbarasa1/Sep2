package main.server.persistence.ingredient;

import main.server.persistence.database.DataConnectionException;
import main.server.persistence.database.IDBConnection;
import main.shared.Ingredient;
import main.shared.Item;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class IngredientDAO implements IIngredientDAO{
    private final IDBConnection databaseConnection;

    public IngredientDAO(IDBConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    @Override
    public ArrayList<Ingredient> getIngredientsByItemId(int id) {
        ArrayList<Ingredient> ingredients =  new ArrayList<>();
        try{
            String sql =    "SELECT i.ingredientName, i.price " +
                            "FROM Ingredient i, ItemIngredient ie " +
                            "WHERE ie.item_ID = "+ id +" AND ie.ingredient_ID = i.ingredient_ID;";
            PreparedStatement preparedStatement = databaseConnection.createPreparedStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while ( resultSet.next()) {
                String name = resultSet.getString("ingredientName");
                double price = resultSet.getDouble("price");
                Ingredient ingredient = new Ingredient(name, price);
                ingredients.add(ingredient);
            }
        } catch (DataConnectionException | SQLException e) {
            e.printStackTrace();
        } finally {
            databaseConnection.closeConnection();
        }
        return ingredients;
    }

    @Override
    public boolean createIngredient(Ingredient ingredient) {
        try{
            String sql = "INSERT INTO Ingredient VALUES(?,?)";
            PreparedStatement preparedStatement = databaseConnection.createPreparedStatement(sql);
            preparedStatement.setString(1, ingredient.getName());
            preparedStatement.setDouble(2, ingredient.getPrice());

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
    public boolean checkIfIngredientExists(Ingredient ingredient) {
        try{
            String sql = "Select * FROM Ingredient where name ="+ingredient.getName();
            PreparedStatement preparedStatement = databaseConnection.createPreparedStatement(sql);
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
    public int getIngredientID(Ingredient ingredient) {
        try {
            PreparedStatement getID = databaseConnection.createPreparedStatement("SELECT OBJECT_ID('" + ingredient.getName() + "')");
            ResultSet resultSet = getID.executeQuery();
            int id = resultSet.getInt("ingredient_ID");

        } catch (DataConnectionException | SQLException e) {
            e.printStackTrace();
        }
        return id;
    }
}
