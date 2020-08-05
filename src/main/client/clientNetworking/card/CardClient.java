package main.client.clientNetworking.card;

import main.client.clientNetworking.rmi.ClientRMIHandler;
import main.shared.Order;

public class CardClient implements ICardClient {
    private ClientRMIHandler rmiHandler;

    public CardClient(ClientRMIHandler rmiHandler) {
        this.rmiHandler = rmiHandler;
    }

    @Override
    public String makeOrder(String cardNumber, String expiration, String securityNumber, Order order) {
        if(makePayment(cardNumber, expiration, securityNumber)){
            rmiHandler.makeOrder(order);
            return "OK";
        }else {
            return "Bad card";
        }
    }

    private boolean makePayment(String cardNumber, String expiration, String securityNumber) {
        return true;
    }
}
