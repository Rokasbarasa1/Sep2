package main.client.model.card;

public interface ICardModel {
    int getId();
    void clearCart();
    String makeOrder(String cardNumber, String expiration, String securityNumber, String method);
}
