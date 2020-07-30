package main.client.model.receptionistMenu;

import main.shared.Item;
import main.shared.Order;
import main.shared.PropertyChangeSubject;

import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public interface IReceptionistMenuModel extends PropertyChangeSubject {
    void loadReceptionist();
    ArrayList<Item> getMenu();
    ArrayList<Order> getIncompleteOrders();
    void completeOrder(int id);
}
