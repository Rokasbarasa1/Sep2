package main.server.model.addItem;

import main.server.rmi.RmiHandler;
import main.shared.Item;


public interface IAddItem {
    void addItemWithIngredients(Item item);
    void setRmiHandler(RmiHandler rmiHandler);
}
