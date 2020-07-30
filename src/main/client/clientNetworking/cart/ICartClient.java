package main.client.clientNetworking.cart;

import main.shared.Order;

public interface ICartClient {
    int getIdForOrder();
    void makeOrder(Order order);
}
