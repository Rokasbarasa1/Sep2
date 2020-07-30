package main.client.viewModel;

import main.client.model.orderScreen.IOrderScreenModel;
import main.shared.Order;
import main.shared.PropertyChangeSubject;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class OrderScreenViewModel implements PropertyChangeSubject {
    private IOrderScreenModel model;
    private PropertyChangeSupport orderUpdateSupport = new PropertyChangeSupport(this);

    public OrderScreenViewModel(IOrderScreenModel model) {
        this.model = model;
        model.addPropertyChangeListener(evt -> newOrderOrStatusUpdate());
    }

    public void newOrderOrStatusUpdate(){
        orderUpdateSupport.firePropertyChange("Updated order list", null, null);
    }

    public ArrayList<Order> getOrders() {
        return model.getOrders();
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        orderUpdateSupport.addPropertyChangeListener(listener);
    }
}
