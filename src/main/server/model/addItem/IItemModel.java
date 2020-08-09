package main.server.model.addItem;

import main.server.rmi.RmiHandler;
import main.shared.Item;


public interface IItemModel {
    void addItemToMenu(Item item);
    void setRmiHandler(RmiHandler rmiHandler);
}
