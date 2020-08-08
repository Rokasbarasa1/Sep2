package main.client.model.card;

import javafx.beans.property.StringProperty;

public interface ICardModel {
    String makeOrder(String cardNumber, String expiration, String securityNumber);
    int getId();
    void clearCart();
}
