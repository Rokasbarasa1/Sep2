package main.server.model.addItem;

import main.server.persistence.ItemIngredient.ItemIngredientDAO;
import main.server.persistence.ingredient.IngredientDAO;
import main.server.persistence.item.ItemDAO;
import main.server.rmi.RmiHandler;
import main.shared.Ingredient;
import main.shared.Item;

public class ItemModel implements IItemModel {

    private ItemDAO itemDAO;
    private IngredientDAO ingredientDAO;
    private ItemIngredientDAO itemIngredientDAO;


    public ItemModel(ItemDAO itemDAO, IngredientDAO ingredientDAO) {
        this.itemDAO = itemDAO;
        this.ingredientDAO = ingredientDAO;
    }

    public void addItemToMenu(Item item){
        itemDAO.addItem(item);
        for (int i = 0; i<item.getIngredientsList().size(); i++){
            if (ingredientDAO.checkIfIngredientExists(item.getIngredientsList().get(i)) == true){
                ingredientDAO.getIngredientID(item.getIngredientsList().get(i));
            }
            else{
                ingredientDAO.createIngredient(item.getIngredientsList().get(i));
                ingredientDAO.getIngredientID(item.getIngredientsList().get(i));
            }
            itemIngredientDAO.insertIDIntoTable(itemDAO.getItemID(item), ingredientDAO.getIngredientID(item.getIngredientsList().get(i)));
        }
    }

    @Override
    public void setRmiHandler(RmiHandler rmiHandler) { this.rmiHandler = rmiHandler; }
}
