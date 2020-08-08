package main.server.model.addItem;

import main.server.rmi.RmiHandler;
import main.shared.Ingredient;
import main.shared.Item;

import java.util.ArrayList;

public interface IAddItem {
    void addItemWithIngredients(Item item, ArrayList<Ingredient> ingredients);
    void setRmiHandler(RmiHandler rmiHandler);
}
