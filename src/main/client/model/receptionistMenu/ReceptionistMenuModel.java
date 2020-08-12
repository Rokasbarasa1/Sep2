package main.client.model.receptionistMenu;

import main.client.clientNetworking.receptionistMenu.IReceptionistMenuClient;
import main.client.model.login.ILoginModel;
import main.shared.Item;
import main.shared.Order;
import main.shared.Receptionist;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class ReceptionistMenuModel implements IReceptionistMenuModel{
    private Receptionist currentUser;
    private IReceptionistMenuClient client;
    private ILoginModel loginModel;
    private PropertyChangeSupport newOrderSupport = new PropertyChangeSupport(this);
    private ArrayList<Item> menu;
    private ArrayList<Order> orders;

    public ReceptionistMenuModel(IReceptionistMenuClient receptionistMenuClient, ILoginModel login) {
        client = receptionistMenuClient;
        loginModel = login;
        client.addPropertyChangeListener(evt -> newOrder());
    }

    @Override
    public void loadReceptionist() {
        currentUser = client.getReceptionist(loginModel.getCurrentUser().getID());
    }

    @Override
    public ArrayList<Item> getMenu() {
        menu = client.getMenu();
        return menu;
    }

    @Override
    public ArrayList<Order> getIncompleteOrders() {
        orders = client.getIncompleteOrders();
        return orders;
    }

    @Override
    public String completeOrder(int id) {
        return client.completeOrder(id);
    }

    @Override
    public String deleteItem(int id) {
        return client.deleteItem(id);
    }

    public void newOrder(){
        newOrderSupport.firePropertyChange("New Order", null, null);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        newOrderSupport.addPropertyChangeListener(listener);
    }
}
