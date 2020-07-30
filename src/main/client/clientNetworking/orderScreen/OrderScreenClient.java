package main.client.clientNetworking.orderScreen;

import main.client.clientNetworking.rmi.ClientRMIHandler;
import main.shared.Order;

import java.util.ArrayList;

public class OrderScreenClient implements IOrderScreenClient{
    private ClientRMIHandler rmiHandler;

    public OrderScreenClient(ClientRMIHandler rmiHandler) {
        this.rmiHandler = rmiHandler;
    }

    @Override
    public ArrayList<Order> getOrders() {
        return rmiHandler.getOrders();
    }
}
