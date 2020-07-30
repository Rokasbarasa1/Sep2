package main.client.clientNetworking.orderScreen;

import main.shared.Order;

import java.util.ArrayList;

public interface IOrderScreenClient {
    ArrayList<Order> getOrders();
}
