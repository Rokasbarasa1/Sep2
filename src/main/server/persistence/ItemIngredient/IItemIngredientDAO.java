package main.server.persistence.ItemIngredient;

public interface IItemIngredientDAO {
    boolean insertIDIntoTable(int item_ID, int ingredient_ID);
}
