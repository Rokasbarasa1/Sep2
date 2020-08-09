package main.server.model.menu;

import main.server.persistence.ItemIngredient.IItemIngredientDAO;
import main.server.persistence.ingredient.IIngredientDAO;
import main.server.persistence.item.IItemDAO;
import main.shared.Item;
import java.util.ArrayList;

public class MenuModel implements IMenuModel {
    private IItemDAO itemDAO;
    private IItemIngredientDAO itemIngredientDAO;
    private IIngredientDAO ingredientDAO;

    public MenuModel(IItemDAO itemDAO, IIngredientDAO ingredientDAO, IItemIngredientDAO itemIngredientDAO) {
        this.itemDAO = itemDAO;
        this.ingredientDAO = ingredientDAO;
        this.itemIngredientDAO = itemIngredientDAO;
    }

    @Override
    public ArrayList<Item> getMenu(){
        ArrayList<Item> items = itemDAO.getMenuItems();
        for (int i = 0; i < items.size(); i++) {
            items.get(i).setIngredients(ingredientDAO.getIngredientsByItemId(items.get(i).getID()));
        }
        return items;
    }

    public String addItemToMenu(Item item){
        itemDAO.addItem(item);
        for (int i = 0; i < item.getIngredientsList().size(); i++){
            if (ingredientDAO.checkIfIngredientExists(item.getIngredientsList().get(i)) == true){
                ingredientDAO.getIngredientID(item.getIngredientsList().get(i));
            }
            else{
                ingredientDAO.createIngredient(item.getIngredientsList().get(i));
                ingredientDAO.getIngredientID(item.getIngredientsList().get(i));
            }
            itemIngredientDAO.insertIDIntoTable(itemDAO.getItemID(item), ingredientDAO.getIngredientID(item.getIngredientsList().get(i)));
        }
        return "OK";
    }

    @Override
    public void deleteItemFromMenu(int id) {
        itemIngredientDAO.deleteAllByItemID(id);
        itemDAO.deleteItemById(id);
        ingredientDAO.deleteIngredientsWithoutPairs();
    }
}
