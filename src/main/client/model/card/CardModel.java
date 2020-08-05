package main.client.model.card;

import main.client.clientNetworking.card.ICardClient;
import main.client.model.cart.ICartModel;
import main.client.model.customerMenu.ICustomerMenuModel;
import main.shared.Order;

public class CardModel implements ICardModel{
    private ICardClient client;
    private ICustomerMenuModel menuModel;
    private ICartModel cartModel;
    public CardModel(ICardClient cardClient, ICustomerMenuModel menuModel, ICartModel cartModel) {
        client = cardClient;
        this.menuModel = menuModel;
        this.cartModel = cartModel;
    }

    @Override
    public String makeOrder(String cardNumber, String expiration, String securityNumber) {
        Order order = new Order(cartModel.getIdForOrder(), menuModel.getCart());
        return client.makeOrder(cardNumber, expiration, securityNumber, order);
    }

    @Override
    public int getId() {
        return cartModel.getIdSaved();
    }

    @Override
    public void clearCart() {
        menuModel.clear();
    }
}
