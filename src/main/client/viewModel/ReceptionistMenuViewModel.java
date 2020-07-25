package main.client.viewModel;

import main.client.model.receptionistMenu.IReceptionistMenuModel;
import main.shared.Item;
import main.shared.Order;
import main.shared.PropertyChangeSubject;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class ReceptionistMenuViewModel implements PropertyChangeSubject {
    private IReceptionistMenuModel model;
    private PropertyChangeSupport newOrderSupport = new PropertyChangeSupport(this);
    public ReceptionistMenuViewModel(IReceptionistMenuModel receptionistMenuModel) {
        this.model = receptionistMenuModel;
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

    public ArrayList<Order> getOrders() {
        return model.getOrders();
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        newOrderSupport.addPropertyChangeListener(listener);
    }
}
