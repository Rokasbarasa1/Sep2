package main.client.clientNetworking.orderScreen;

import main.shared.Order;
import main.shared.PropertyChangeSubject;

import java.util.ArrayList;

public interface IOrderScreenClient extends PropertyChangeSubject {
    ArrayList<Order> getOrders();
}
