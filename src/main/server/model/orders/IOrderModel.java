package main.server.model.orders;

import main.shared.Item;
import main.shared.Order;

import java.util.ArrayList;

public interface IOrderModel {
    ArrayList<Order> getOrders();
    ArrayList<Order> getUnfinishedOrders();
    int getIdForOrder(Order order);
    void makeOrder(Order order);
    void completeID(int ID);
}
