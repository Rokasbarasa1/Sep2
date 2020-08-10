package main.server.model.orders;

import main.server.rmi.RmiHandler;
import main.shared.Item;
import main.shared.Order;

import java.util.ArrayList;

public interface IOrderModel {
    ArrayList<Order> getOrders();
    ArrayList<Order> getUnfinishedOrders();
    int getIdForOrder();
    String makeOrder(Order order);
    String completeID(int ID);
    void setRmiHandler(RmiHandler rmiHandler);
}
