package main.client.model.orderScreen;

import main.shared.Order;
import main.shared.PropertyChangeSubject;

import java.util.ArrayList;

public interface IOrderScreenModel extends PropertyChangeSubject {
    ArrayList<Order> getOrders();
}
