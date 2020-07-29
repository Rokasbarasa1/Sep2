package main.server.model;

import main.server.persistence.ingredient.IIngredientDAO;
import main.server.persistence.item.IItemDAO;
import main.shared.Item;

import java.util.ArrayList;

public class MenuModel implements IMenuModel{
    private IItemDAO itemDAO;
    private IIngredientDAO ingredientDAO;

    public MenuModel(IItemDAO itemDAO, IIngredientDAO ingredientDAO) {
        this.itemDAO = itemDAO;
        this.ingredientDAO = ingredientDAO;
    }

    public ArrayList<Item> getMenu(){
        ArrayList<Item> items = itemDAO.getMenuItems();
        for (int i = 0; i < items.size(); i++) {
            items.get(i).setIngredients(ingredientDAO.getIngredientsByItemId(items.get(i).getID()));
        }
        return items;
    }
}
