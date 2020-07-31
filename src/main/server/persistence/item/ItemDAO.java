package main.server.persistence.item;

import main.server.persistence.database.DataConnectionException;
import main.server.persistence.database.IDBConnection;
import main.shared.Ingredient;
import main.shared.Item;
import main.shared.Receptionist;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemDAO implements IItemDAO{
    private final IDBConnection databaseConnection;

    public ItemDAO(IDBConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    @Override
    public ArrayList<Item> getMenuItems() {
        ArrayList<Item> items = new ArrayList<>();
        try{
            String sql = "SELECT * FROM Item;";
            PreparedStatement preparedStatement = databaseConnection.createPreparedStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while ( resultSet.next()) {
                int id = resultSet.getInt("item_ID");
                String name = resultSet.getString("itemName");
                boolean customizable = resultSet.getBoolean("customizable");
                double price = resultSet.getDouble("price");
                String groupName = resultSet.getString("groupName");

                Item item = new Item(id, name,  customizable,  price,  groupName);
                items.add(item);
            }
        } catch (DataConnectionException | SQLException e) {
            e.printStackTrace();
        } finally {
            databaseConnection.closeConnection();
        }
        return items;
    }
}
