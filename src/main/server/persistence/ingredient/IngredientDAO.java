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
            String sql =    "insert into Ingredient(ingredientName, price) values (?,?);";
            PreparedStatement preparedStatement = databaseConnection.createPreparedStatement(sql);
            preparedStatement.setString(1, ingredient.getName());
            preparedStatement.setDouble(2, ingredient.getPrice());
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0){
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
            String sql = "Select * FROM Ingredient WHERE ingredientName = '"+ingredient.getName() + "';";
            PreparedStatement preparedStatement = databaseConnection.createPreparedStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                return true;
            }else {
                return false;
            }
        } catch (DataConnectionException | SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            databaseConnection.closeConnection();
        }
    }
    public int getIngredientID(Ingredient ingredient) {
        int id = 0;
        try {
            String sql =    "SELECT ingredient_ID FROM Ingredient " +
                            "WHERE ingredientName = '" + ingredient.getName() +"';";
            PreparedStatement getID = databaseConnection.createPreparedStatement(sql);
            ResultSet resultSet = getID.executeQuery();
            if(resultSet.next()){
                id = resultSet.getInt("ingredient_ID");
            }
        } catch (DataConnectionException | SQLException e) {
            e.printStackTrace();
        } finally {
            databaseConnection.closeConnection();
        }
        return id;
    }

    @Override
    public void deleteIngredientsWithoutPairs() {
        try{
            String sql = "DELETE FROM Ingredient WHERE ingredient_ID NOT IN (SELECT ingredient_ID FROM ItemIngredient);";
            PreparedStatement preparedStatement = databaseConnection.createPreparedStatement(sql);
            int i = preparedStatement.executeUpdate();
            if(i >0){
                System.out.println("Ingredients deleted");
            }
        } catch (DataConnectionException | SQLException e) {
            e.printStackTrace();
        } finally {
            databaseConnection.closeConnection();
        }
    }
}
