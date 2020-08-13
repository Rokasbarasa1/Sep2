package main.client.clientNetworking.card;

import main.shared.Order;

public interface ICardClient {
    String makeOrder(String cardNumber, String expiration, String securityNumber, String method, Order order);
    int getIdForOrder();
}
