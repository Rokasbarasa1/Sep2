package main.client.model.orderScreen;

import main.client.clientNetworking.orderScreen.IOrderScreenClient;
import main.shared.Ingredient;
import main.shared.Item;
import main.shared.Order;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class OrderScreenModel implements IOrderScreenModel{
    private IOrderScreenClient client;
    private PropertyChangeSupport orderUpdateSupport = new PropertyChangeSupport(this);

    public OrderScreenModel(IOrderScreenClient client) {
        this.client = client;
        client.addPropertyChangeListener(evt -> newOrderOrStatusUpdate());
    }

    @Override
    public ArrayList<Order> getOrders() {
        return client.getOrders();
    }

    public void newOrderOrStatusUpdate(){
        orderUpdateSupport.firePropertyChange("Updated order list", null, null);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        orderUpdateSupport.addPropertyChangeListener(listener);
    }
}
