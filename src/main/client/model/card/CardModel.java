package main.client.model.card;

import main.client.clientNetworking.card.ICardClient;
import main.client.model.customerMenu.ICustomerMenuModel;
import main.shared.Order;

public class CardModel implements ICardModel{
    private ICardClient client;
    private ICustomerMenuModel menuModel;
    private int id;
    public CardModel(ICardClient cardClient, ICustomerMenuModel menuModel) {
        client = cardClient;
        this.menuModel = menuModel;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void clearCart() {
        menuModel.clear();
    }

    @Override
    public String makeOrder(String cardNumber, String expiration, String securityNumber, String method) {
        id = client.getIdForOrder();
        if(id != -1){
            Order order = new Order(id, menuModel.getCart());
            return client.makeOrder(cardNumber, expiration, securityNumber, method, order);
        }else {
            return "Problem getting id for order. Possibly connection problem";
        }
    }
}
