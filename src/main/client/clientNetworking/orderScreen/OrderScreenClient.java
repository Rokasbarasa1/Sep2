package main.client.clientNetworking.orderScreen;

import main.client.clientNetworking.rmi.ClientRMIHandler;
import main.shared.Order;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class OrderScreenClient implements IOrderScreenClient{
    private ClientRMIHandler rmiHandler;
    private PropertyChangeSupport orderUpdateSupport = new PropertyChangeSupport(this);

    public OrderScreenClient(ClientRMIHandler rmiHandler) {
        this.rmiHandler = rmiHandler;
        rmiHandler.addPropertyChangeListenerOrderListUpdate(evt -> newOrderOrStatusUpdate());
    }

    @Override
    public ArrayList<Order> getOrders() {
        return rmiHandler.getOrders();
    }

    public void newOrderOrStatusUpdate() {
        orderUpdateSupport.firePropertyChange("Updated order list", null, null);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        orderUpdateSupport.addPropertyChangeListener(listener);
    }
}
