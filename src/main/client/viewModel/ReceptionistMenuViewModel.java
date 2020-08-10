package main.client.viewModel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import main.client.model.receptionistMenu.IReceptionistMenuModel;
import main.shared.Item;
import main.shared.Order;
import main.shared.PropertyChangeSubject;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class ReceptionistMenuViewModel implements PropertyChangeSubject {
    private IReceptionistMenuModel model;
    private StringProperty menuResponse;
    private StringProperty orderResponse;
    private PropertyChangeSupport newOrderSupport = new PropertyChangeSupport(this);

    public ReceptionistMenuViewModel(IReceptionistMenuModel receptionistMenuModel) {
        this.model = receptionistMenuModel;
        menuResponse = new SimpleStringProperty();
        orderResponse = new SimpleStringProperty();
        model.addPropertyChangeListener(evt -> newOrder());
    }

    private void newOrder() {
        newOrderSupport.firePropertyChange("New Order", null, null);
    }

    public void loadReceptionist() {
        model.loadReceptionist();
    }

    public ArrayList<Item> getMenu() {
        return model.getMenu();
    }

    public ArrayList<Order> getIncompleteOrders() {
        return model.getIncompleteOrders();
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        newOrderSupport.addPropertyChangeListener(listener);
    }

    public void completeOrder(int id) {
        orderResponse.setValue(model.completeOrder(id));
    }

    public void deleteItem(int id) {
        menuResponse.setValue(model.deleteItem(id));
    }

    public StringProperty orderResponseProperty() {
        return orderResponse;
    }

    public StringProperty menuResponseProperty() {
        return menuResponse;
    }
}
