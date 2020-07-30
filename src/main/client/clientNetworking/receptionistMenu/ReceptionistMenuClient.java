package main.client.clientNetworking.receptionistMenu;

import main.client.clientNetworking.rmi.ClientRMIHandler;
import main.shared.Item;
import main.shared.Order;
import main.shared.Receptionist;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class ReceptionistMenuClient implements IReceptionistMenuClient {
    private ClientRMIHandler rmiHandler;
    private PropertyChangeSupport newOrderSupport = new PropertyChangeSupport(this);

    public ReceptionistMenuClient(ClientRMIHandler rmiHandler) {
        this.rmiHandler = rmiHandler;
        rmiHandler.addPropertyChangeListener(evt -> newOrder());
    }

    private void newOrder() {
        newOrderSupport.firePropertyChange("New Order",null, null);
    }

    @Override
    public Receptionist getReceptionist(int userId) {
        return rmiHandler.getReceptionistById(userId);
    }

    @Override
    public ArrayList<Item> getMenu() {
        return rmiHandler.getMenu();
    }

    @Override
    public ArrayList<Order> getOrders() {
        return rmiHandler.getOrders();
    }

    @Override
    public void completeOrder(int id) {
        rmiHandler.completeOrder(id);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        newOrderSupport.addPropertyChangeListener(listener);
    }
}
