package main.client.clientNetworking.receptionistMenu;

import main.shared.Item;
import main.shared.Order;
import main.shared.PropertyChangeSubject;
import main.shared.Receptionist;

import java.util.ArrayList;

public interface IReceptionistMenuClient extends PropertyChangeSubject {
    Receptionist getReceptionist(int currentUser);
    ArrayList<Item> getMenu();
    ArrayList<Order> getIncompleteOrders();
    void completeOrder(int id);
}
