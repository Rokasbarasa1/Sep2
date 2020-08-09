package main.client.clientNetworking.card;

import main.client.clientNetworking.rmi.ClientRMIHandler;
import main.shared.Order;

public class CardClient implements ICardClient {
    private ClientRMIHandler rmiHandler;

    public CardClient(ClientRMIHandler rmiHandler) {
        this.rmiHandler = rmiHandler;
    }

    private boolean makePayment(String cardNumber, String expiration, String securityNumber, String method) {
        return true;
    }

    @Override
    public String makeOrder(String cardNumber, String expiration, String securityNumber, String method, Order order) {
        System.out.println(order.getItemsForPrinting());
        if(makePayment(cardNumber, expiration, securityNumber, method)){
            return rmiHandler.makeOrder(order);
        }else {
            return "Bad card";
        }
    }

    @Override
    public int getIdForOrder() {
        return rmiHandler.getIdForOrder();
    }
}
