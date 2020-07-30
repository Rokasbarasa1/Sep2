package main.client.clientNetworking.cart;

import main.client.clientNetworking.rmi.ClientRMIHandler;
import main.shared.Order;

public class CartClient implements ICartClient{
    private ClientRMIHandler rmiHandler;
    public CartClient(ClientRMIHandler rmiHandler) {
        this.rmiHandler = rmiHandler;
    }

    @Override
    public int getIdForOrder() {
        return rmiHandler.getIdForOrder();
    }

    @Override
    public void makeOrder(Order order) {
        rmiHandler.makeOrder(order);
    }
}
